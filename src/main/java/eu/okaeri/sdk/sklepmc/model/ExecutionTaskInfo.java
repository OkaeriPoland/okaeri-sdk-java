package eu.okaeri.sdk.sklepmc.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ExecutionTaskInfo {
    @SerializedName("buyer") private final String buyer;
    @SerializedName("transaction_id") private final String transactionId;
    @SerializedName("commands") private final List<ExecutionCommandInfo> commands;
    @SerializedName("require_online") private final boolean requireOnline;
}
