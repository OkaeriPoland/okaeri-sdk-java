package eu.okaeri.sdk.noproxy;

import eu.okaeri.sdk.OkaeriSdkClient;
import eu.okaeri.sdk.noproxy.error.NoProxyException;
import eu.okaeri.sdk.noproxy.model.NoProxyAddressInfo;
import eu.okaeri.sdk.noproxy.model.NoProxyError;
import kong.unirest.Config;

public class NoProxyClient extends OkaeriSdkClient {

    public NoProxyClient() {
        this(null);
    }

    public NoProxyClient(String token) {
        this(
                resolveBaseUrl("OKAERI_SDK_NOPROXY_BASE_PATH", "https://noproxy-api.okaeri.eu"),
                resolveTimeout("OKAERI_SDK_TIMEOUT", 5000),
                resolveToken("OKAERI_SDK_NOPROXY_TOKEN", token)
        );
    }

    public NoProxyClient(String baseUrl, int timeout, String token) {
        super(new Config()
                .socketTimeout(timeout)
                .connectTimeout(timeout)
                .addDefaultHeader("Authorization", "Bearer " + token)
                .defaultBaseUrl(baseUrl)
        );
    }

    public NoProxyAddressInfo getInfo(String address) throws NoProxyException {
        return super.getUnirest()
                .get("/v1/" + encode(address))
                .asObject(NoProxyAddressInfo.class)
                .ifFailure(NoProxyError.class, NoProxyError.CONSUMER)
                .getBody();
    }
}
