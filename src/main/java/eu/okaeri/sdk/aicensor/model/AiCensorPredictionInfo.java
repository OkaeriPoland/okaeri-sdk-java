package eu.okaeri.sdk.aicensor.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

import java.util.UUID;

@Data
public class AiCensorPredictionInfo {
    @SerializedName("id") private final UUID id;
    @SerializedName("general") private final AiCensorPredictionGeneralInfo general;
    @SerializedName("details") private final AiCensorPredictionDetailsInfo details;
    @SerializedName("elapsed") private final AiCensorPredictionElapsedInfo elapsed;
}
