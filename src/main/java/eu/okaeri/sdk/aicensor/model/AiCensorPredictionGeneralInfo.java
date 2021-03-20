package eu.okaeri.sdk.aicensor.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
public class AiCensorPredictionGeneralInfo {
    @SerializedName("swear") private final boolean swear;
    @SerializedName("breakdown") private final String breakdown;
    @SerializedName("domains") private final boolean domains;
}
