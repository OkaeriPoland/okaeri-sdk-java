package eu.okaeri.sdk.sklepmc.error;

import eu.okaeri.sdk.sklepmc.model.SklepMcError;
import lombok.Getter;

public class SklepMcException extends RuntimeException {

    @Getter private SklepMcError apiError;

    public SklepMcException(SklepMcError apiError, String s) {
        super(s);
        this.apiError = apiError;
    }

    public SklepMcException(SklepMcError apiError, String s, Throwable throwable) {
        super(s, throwable);
        this.apiError = apiError;
    }

    public SklepMcException(SklepMcError apiError, Throwable throwable) {
        super(throwable);
        this.apiError = apiError;
    }

    public SklepMcException(SklepMcError apiError, String s, Throwable throwable, boolean b1, boolean b2) {
        super(s, throwable, b1, b2);
        this.apiError = apiError;
    }
}
