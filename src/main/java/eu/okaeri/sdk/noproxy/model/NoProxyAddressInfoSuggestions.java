package eu.okaeri.sdk.noproxy.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
public class NoProxyAddressInfoSuggestions {
    @SerializedName("verify") private final boolean verify;
    @SerializedName("block") private final boolean block;
}
