package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class NoProxyAddressInfoGeneral {
    @SerializedName("ip") private final String ip;
    @SerializedName("asn") private final int asn;
    @SerializedName("provider") private final String provider;
    @SerializedName("country") private final String country;
}
