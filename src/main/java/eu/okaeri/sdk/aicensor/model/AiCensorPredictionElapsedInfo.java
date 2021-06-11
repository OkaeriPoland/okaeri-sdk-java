package eu.okaeri.sdk.aicensor.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class AiCensorPredictionElapsedInfo implements Serializable {
    @SerializedName("all") private final double all;
    @SerializedName("processing") private final double processing;
}
