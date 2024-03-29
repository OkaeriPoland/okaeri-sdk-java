package eu.okaeri.sdk.openvote.model.vote;

import eu.okaeri.sdk.openvote.error.OpenVoteException;
import kong.unirest.HttpResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.function.Consumer;

@Data
public class OpenVoteError implements Serializable {

    public static final Consumer<HttpResponse<OpenVoteError>> CONSUMER = response -> {
        OpenVoteError error = (response.getBody() == null)
            ? new OpenVoteError(response.getStatus(), "UNKNOWN", response.getStatus() + " " + response.getStatusText())
            : response.getBody();
        String message = "Error handling request (" + error.error + " - " + error.message + ")";
        throw new OpenVoteException(error, message);
    };

    private final int status;
    private final String error;
    private final String message;
}
