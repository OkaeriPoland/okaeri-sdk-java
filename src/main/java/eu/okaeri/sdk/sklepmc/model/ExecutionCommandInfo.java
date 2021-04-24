package eu.okaeri.sdk.sklepmc.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ExecutionCommandInfo {
    @SerializedName("text") private final String text;
    @SerializedName("target") private final String target;
}
