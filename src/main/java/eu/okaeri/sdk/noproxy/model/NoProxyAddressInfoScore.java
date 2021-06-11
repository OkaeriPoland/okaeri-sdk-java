package eu.okaeri.sdk.noproxy.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoProxyAddressInfoScore implements Serializable {
    @SerializedName("noproxy") private final int noproxy;
    @SerializedName("abuseipdb") private final int abuseipdb;
}
