package eu.okaeri.sdk.sklepmc;

import eu.okaeri.sdk.OkaeriSdkClient;
import eu.okaeri.sdk.aicensor.error.AiCensorException;
import eu.okaeri.sdk.sklepmc.model.ExecutionTaskInfo;
import eu.okaeri.sdk.sklepmc.model.SklepMcError;
import kong.unirest.Config;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class SklepMcClient extends OkaeriSdkClient {

    @Getter private final String shopId;

    public SklepMcClient() {
        this(null, null);
    }

    public SklepMcClient(String token, String shopId) {
        this(
                resolveBaseUrl("OKAERI_SDK_SKLEPMC_BASE_PATH", "https://www.sklepmc.pl/api"),
                resolveTimeout("OKAERI_SDK_TIMEOUT", 5000),
                resolveToken("OKAERI_SDK_SKLEPMC_TOKEN", token),
                resolveToken("OKAERI_SDK_SKLEPMC_SHOP_ID", shopId)
        );
    }

    public SklepMcClient(String baseUrl, int timeout, String token, String shopId) {
        super(new Config()
                .socketTimeout(timeout)
                .connectTimeout(timeout)
                .addDefaultHeader("X-Api-Secret", token)
                .defaultBaseUrl(baseUrl)
        );
        this.shopId = shopId;
    }

    public List<ExecutionTaskInfo> getAwaitingExecution(int serverId) throws AiCensorException {
        return Arrays.asList(super.getUnirest()
                .get("/" + encode(this.shopId) + "/server/" + serverId + "/awaitingExecution")
                .asObject(ExecutionTaskInfo[].class)
                .ifFailure(SklepMcError.class, SklepMcError.CONSUMER)
                .getBody());
    }

    public boolean updateStatus(String transactionId, String status) {
        return "OK".equals(super.getUnirest()
                .post("/" + encode(this.shopId) + "/transaction/" + encode(transactionId) + "/status")
                .body(status)
                .asString()
                .ifFailure(SklepMcError.class, SklepMcError.CONSUMER)
                .getBody());
    }
}
