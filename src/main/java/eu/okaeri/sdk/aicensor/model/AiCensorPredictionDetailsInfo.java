package eu.okaeri.sdk.aicensor.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AiCensorPredictionDetailsInfo implements Serializable {
    @SerializedName("basic_contains_hit") private final boolean basicContainsHit;
    @SerializedName("exact_match_hit") private final boolean exactMatchHit;
    @SerializedName("ai_label") private final String aiLabel;
    @SerializedName("ai_probability") private final double aiProbability;
    @SerializedName("domains_list") private final List<String> domainsList;
}
