package eu.okaeri.sdk.noproxy.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
public class NoProxyAddressInfo {
    @SerializedName("general") private final NoProxyAddressInfoGeneral general;
    @SerializedName("risks") private final NoProxyAddressInfoRisks risks;
    @SerializedName("score") private final NoProxyAddressInfoScore score;
    @SerializedName("suggestions") private final NoProxyAddressInfoSuggestions suggestions;
}
