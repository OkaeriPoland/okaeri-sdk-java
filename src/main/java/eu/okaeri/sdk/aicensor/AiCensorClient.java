package eu.okaeri.sdk.aicensor;

import eu.okaeri.sdk.OkaeriSdkClient;
import eu.okaeri.sdk.aicensor.error.AiCensorException;
import eu.okaeri.sdk.aicensor.model.AiCensorError;
import eu.okaeri.sdk.aicensor.model.AiCensorPredictionInfo;
import kong.unirest.Unirest;

import java.util.Collections;

public class AiCensorClient extends OkaeriSdkClient {

    public AiCensorClient() {
        this(null);
    }

    public AiCensorClient(String token) {
        this(
                resolveBaseUrl("OKAERI_SDK_AICENSOR_BASE_PATH", "https://ai-censor.okaeri.eu"),
                resolveTimeout("OKAERI_SDK_TIMEOUT", 5000),
                resolveToken("OKAERI_SDK_AICENSOR_TOKEN", token)
        );
    }

    public AiCensorClient(String baseUrl, int timeout, String token) {
        super(Unirest.config()
                .socketTimeout(timeout)
                .connectTimeout(timeout)
                .addDefaultHeader("Token", token)
                .defaultBaseUrl(baseUrl)
        );
    }

    public AiCensorPredictionInfo getPrediction(String phrase) throws AiCensorException {
        return super.getUnirest()
                .post("/predict")
                .body(Collections.singletonMap("phrase", phrase))
                .asObject(AiCensorPredictionInfo.class)
                .ifFailure(AiCensorError.class, AiCensorError.CONSUMER)
                .getBody();
    }
}
