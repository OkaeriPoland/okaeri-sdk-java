package eu.okaeri.sdk.sklepmc.model;

import eu.okaeri.sdk.sklepmc.error.SklepMcException;
import kong.unirest.HttpResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.function.Consumer;

@Data
public class SklepMcError implements Serializable {

    public static final Consumer<HttpResponse<SklepMcError>> CONSUMER = response -> {
        SklepMcError error = (response.getBody() == null)
            ? new SklepMcError("UNKNOWN", response.getStatus() + " " + response.getStatusText())
            : response.getBody();
        String message = "Error handling request (" + error.type + " - " + error.message + ")";
        throw new SklepMcException(error, message);
    };

    private final String type;
    private final String message;
}
