package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoProxyAddressInfoSuggestions implements Serializable {
    @SerializedName("verify") private final boolean verify;
    @SerializedName("block") private final boolean block;
}
