package eu.okaeri.sdk.aicensor.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AiCensorPredictionGeneralInfo {
    @SerializedName("swear") private final boolean swear;
    @SerializedName("breakdown") private final String breakdown;
    @SerializedName("domains") private final boolean domains;
}
