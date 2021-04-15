package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class NoProxyAddressInfoSuggestions {
    @SerializedName("verify") private final boolean verify;
    @SerializedName("block") private final boolean block;
}
