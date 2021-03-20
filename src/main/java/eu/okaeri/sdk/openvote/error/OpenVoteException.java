package eu.okaeri.sdk.openvote.error;

import eu.okaeri.sdk.openvote.model.vote.OpenVoteError;

public class OpenVoteException extends RuntimeException {

    private OpenVoteError apiError;

    public OpenVoteException(OpenVoteError apiError, String s) {
        super(s);
        this.apiError = apiError;
    }

    public OpenVoteException(OpenVoteError apiError, String s, Throwable throwable) {
        super(s, throwable);
        this.apiError = apiError;
    }

    public OpenVoteException(OpenVoteError apiError, Throwable throwable) {
        super(throwable);
        this.apiError = apiError;
    }

    public OpenVoteException(OpenVoteError apiError, String s, Throwable throwable, boolean b1, boolean b2) {
        super(s, throwable, b1, b2);
        this.apiError = apiError;
    }

    public OpenVoteError getApiError() {
        return this.apiError;
    }
}
