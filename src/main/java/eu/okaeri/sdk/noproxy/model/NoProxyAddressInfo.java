package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoProxyAddressInfo implements Serializable {
    @SerializedName("general") private final NoProxyAddressInfoGeneral general;
    @SerializedName("risks") private final NoProxyAddressInfoRisks risks;
    @SerializedName("score") private final NoProxyAddressInfoScore score;
    @SerializedName("suggestions") private final NoProxyAddressInfoSuggestions suggestions;
}
