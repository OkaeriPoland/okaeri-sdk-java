package eu.okaeri.sdk.aicensor.error;

import eu.okaeri.sdk.aicensor.model.AiCensorError;
import lombok.Getter;

public class AiCensorException extends RuntimeException {

    @Getter private AiCensorError apiError;

    public AiCensorException(AiCensorError apiError, String s) {
        super(s);
        this.apiError = apiError;
    }

    public AiCensorException(AiCensorError apiError, String s, Throwable throwable) {
        super(s, throwable);
        this.apiError = apiError;
    }

    public AiCensorException(AiCensorError apiError, Throwable throwable) {
        super(throwable);
        this.apiError = apiError;
    }

    public AiCensorException(AiCensorError apiError, String s, Throwable throwable, boolean b1, boolean b2) {
        super(s, throwable, b1, b2);
        this.apiError = apiError;
    }
}
