package eu.okaeri.sdk.aicensor.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AiCensorPredictionInfo implements Serializable {
    @SerializedName("id") private final UUID id;
    @SerializedName("general") private final AiCensorPredictionGeneralInfo general;
    @SerializedName("details") private final AiCensorPredictionDetailsInfo details;
    @SerializedName("elapsed") private final AiCensorPredictionElapsedInfo elapsed;
}
