package eu.okaeri.sdk;

import kong.unirest.Config;
import kong.unirest.UnirestInstance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OkaeriSdkClient {

    private static final String USER_AGENT = "okaeri-sdk/1 (java)";

    private final UnirestInstance unirest;

    public OkaeriSdkClient(Config config) {
        this.unirest = new UnirestInstance(config
                .addDefaultHeader("User-Agent", USER_AGENT)
                .followRedirects(true)
                .enableCookieManagement(false));
    }

    protected static int resolveTimeout(String envName, int defaultValue) {
        return Integer.getInteger(envName, defaultValue);
    }

    protected static String resolveToken(String envName, String token) {
        String result = ((token == null) || "".equals(token))
                ? System.getProperty(envName)
                : token;
        if (result == null) {
            throw new IllegalArgumentException("token cannot be null");
        }
        return result;
    }

    protected static String resolveBaseUrl(String envName, String defaultValue) {
        return System.getProperty(envName, defaultValue);
    }
}
