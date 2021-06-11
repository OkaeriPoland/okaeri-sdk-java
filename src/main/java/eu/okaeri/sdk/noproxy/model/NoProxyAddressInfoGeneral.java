package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoProxyAddressInfoGeneral implements Serializable {
    @SerializedName("ip") private final String ip;
    @SerializedName("asn") private final int asn;
    @SerializedName("provider") private final String provider;
    @SerializedName("country") private final String country;
}
