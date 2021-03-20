package eu.okaeri.sdk.aicensor.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
public class AiCensorPredictionElapsedInfo {
    @SerializedName("all") private final double all;
    @SerializedName("processing") private final double processing;
}
