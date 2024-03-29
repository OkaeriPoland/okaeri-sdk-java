package eu.okaeri.sdk.noproxy.model;

import eu.okaeri.sdk.noproxy.error.NoProxyException;
import kong.unirest.HttpResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.function.Consumer;

@Data
public class NoProxyError implements Serializable {

    public static final Consumer<HttpResponse<NoProxyError>> CONSUMER = response -> {
        NoProxyError error = (response.getBody() == null)
            ? new NoProxyError(response.getStatus(), "UNKNOWN", response.getStatus() + " " + response.getStatusText())
            : response.getBody();
        String message = "Error handling request (" + error.error + " - " + error.message + ")";
        throw new NoProxyException(error, message);
    };

    private final int status;
    private final String error;
    private final String message;
}
