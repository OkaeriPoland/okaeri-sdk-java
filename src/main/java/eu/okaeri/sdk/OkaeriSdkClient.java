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
        return Integer.parseInt(getPropertyOrEnv(envName, String.valueOf(defaultValue)));
    }

    protected static String resolveToken(String envName, String token) {
        String result = ((token == null) || "".equals(token))
                ? getPropertyOrEnv(envName)
                : token;
        if (result == null) {
            throw new IllegalArgumentException("token cannot be null");
        }
        return result;
    }

    protected static String getPropertyOrEnv(String name) {
        String property = System.getProperty(name);
        return (property == null) ? System.getenv(name) : property;
    }

    protected static String getPropertyOrEnv(String name, String defaultValue) {
        String property = getPropertyOrEnv(name);
        return (property == null) ? defaultValue : property;
    }

    protected static String resolveBaseUrl(String envName, String defaultValue) {
        return getPropertyOrEnv(envName, defaultValue);
    }
}
