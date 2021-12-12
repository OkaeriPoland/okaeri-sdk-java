package eu.okaeri.sdk.sklepmc.execution;

import eu.okaeri.sdk.sklepmc.SklepMcClient;
import eu.okaeri.sdk.sklepmc.model.ExecutionCommandInfo;
import eu.okaeri.sdk.sklepmc.model.ExecutionTaskInfo;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@RequiredArgsConstructor
public abstract class ExecutionWatcher {

    private final SklepMcClient client;
    private final int serverId;
    private final Set<String> awaitingConfirmation = new HashSet<>();

    /**
     * @return total count of executed tasks
     */
    public long update() {
        // try to confirm awaiting transactions failed before
        long successfullyConfirmed = this.awaitingConfirmation.stream()
            .map(this::confirmTransaction)
            .filter(Predicate.isEqual(true))
            .count();
        // fetch and try to execute new tasks
        long successfullyExecuted = this.client.getAwaitingExecution(this.serverId).stream()
            .map(this::executeTask)
            .filter(Predicate.isEqual(true))
            .count();
        // return total count of executed tasks
        return successfullyConfirmed + successfullyExecuted;
    }

    public boolean executeTask(ExecutionTaskInfo executionTask) {

        List<ExecutionCommandInfo> commands = executionTask.getCommands();
        String transactionId = executionTask.getTransactionId();
        boolean requireOnline = executionTask.isRequireOnline();

        // do not execute task if is awaiting confirmation already
        if (this.awaitingConfirmation.contains(executionTask.getTransactionId())) {
            return false;
        }

        // no commands, just confirm
        if (commands.isEmpty()) {
            return this.confirmTransaction(executionTask.getTransactionId());
        }

        // do not execute if not all command targets are online
        if (!commands.stream().map(ExecutionCommandInfo::getTarget).allMatch(this::isOnline)) {
            return false;
        }

        // execute all commands and confirm
        commands.forEach(command -> this.execute(command.getText(), command.getTarget()));
        return this.confirmTransaction(executionTask.getTransactionId());
    }

    public boolean confirmTransaction(String transactionId) {
        try {
            if (this.client.updateStatus(transactionId, "COMPLETED")) {
                this.awaitingConfirmation.remove(transactionId);
                return true;
            }
        } catch (Exception exception) {
            System.out.println("Cannot confirm transaction, retrying later");
            exception.printStackTrace();
        }
        this.awaitingConfirmation.add(transactionId);
        return false;
    }

    public boolean isOnline(String target) {
        return true;
    }

    public abstract boolean execute(String command, String target);
}
