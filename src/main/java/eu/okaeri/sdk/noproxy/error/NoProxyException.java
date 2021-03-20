package eu.okaeri.sdk.noproxy.error;

import eu.okaeri.sdk.noproxy.model.NoProxyError;

public class NoProxyException extends RuntimeException {

    private NoProxyError apiError;

    public NoProxyException(NoProxyError apiError, String s) {
        super(s);
        this.apiError = apiError;
    }

    public NoProxyException(NoProxyError apiError, String s, Throwable throwable) {
        super(s, throwable);
        this.apiError = apiError;
    }

    public NoProxyException(NoProxyError apiError, Throwable throwable) {
        super(throwable);
        this.apiError = apiError;
    }

    public NoProxyException(NoProxyError apiError, String s, Throwable throwable, boolean b1, boolean b2) {
        super(s, throwable, b1, b2);
        this.apiError = apiError;
    }

    public NoProxyError getApiError() {
        return this.apiError;
    }
}
