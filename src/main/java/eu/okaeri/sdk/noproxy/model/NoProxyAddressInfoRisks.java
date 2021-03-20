package eu.okaeri.sdk.noproxy.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
public class NoProxyAddressInfoRisks {
    @SerializedName("total") private final int total;
    @SerializedName("proxy") private final boolean proxy;
    @SerializedName("country") private final boolean country;
    @SerializedName("asn") private final boolean asn;
    @SerializedName("provider") private final boolean provider;
    @SerializedName("abuser") private final boolean abuser;
}
