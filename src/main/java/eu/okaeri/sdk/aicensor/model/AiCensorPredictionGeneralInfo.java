package eu.okaeri.sdk.aicensor.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class AiCensorPredictionGeneralInfo implements Serializable {
    @SerializedName("swear") private final boolean swear;
    @SerializedName("breakdown") private final String breakdown;
    @SerializedName("domains") private final boolean domains;
}
