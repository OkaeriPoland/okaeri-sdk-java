package eu.okaeri.sdk.aicensor.model;

import eu.okaeri.sdk.aicensor.error.AiCensorException;
import kong.unirest.HttpResponse;
import lombok.Data;

import java.util.function.Consumer;

@Data
public class AiCensorError {

    public static final Consumer<HttpResponse<AiCensorError>> CONSUMER = response -> {
        AiCensorError error = (response.getBody() == null)
                ? new AiCensorError("UNKNOWN", response.getStatus() + " " + response.getStatusText())
                : response.getBody();
        String message = "Error handling request (" + error.type + " - " + error.message + ")";
        throw new AiCensorException(error, message);
    };

    private final String type;
    private final String message;

    public enum ErrorType {
        UNKNOWN,
        PARSE_ERROR,
        AUTHORIZATION_FAILED,
        ELEMENT_NOT_FOUND,
        INVALID_INPUT
    }
}