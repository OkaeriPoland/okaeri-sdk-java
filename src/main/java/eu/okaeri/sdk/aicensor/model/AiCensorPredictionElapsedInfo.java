package eu.okaeri.sdk.aicensor.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AiCensorPredictionElapsedInfo {
    @SerializedName("all") private final double all;
    @SerializedName("processing") private final double processing;
}
