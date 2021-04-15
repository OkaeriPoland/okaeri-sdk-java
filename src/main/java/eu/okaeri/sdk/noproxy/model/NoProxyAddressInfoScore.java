package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class NoProxyAddressInfoScore {
    @SerializedName("noproxy") private final int noproxy;
    @SerializedName("abuseipdb") private final int abuseipdb;
}
