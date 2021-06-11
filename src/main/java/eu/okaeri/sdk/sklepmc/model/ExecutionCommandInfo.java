package eu.okaeri.sdk.sklepmc.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExecutionCommandInfo implements Serializable {
    @SerializedName("text") private final String text;
    @SerializedName("target") private final String target;
}
