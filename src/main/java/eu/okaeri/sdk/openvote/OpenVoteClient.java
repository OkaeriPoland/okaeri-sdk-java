package eu.okaeri.sdk.openvote;

import eu.okaeri.sdk.OkaeriSdkClient;
import eu.okaeri.sdk.openvote.error.OpenVoteException;
import eu.okaeri.sdk.openvote.model.list.OpenVoteListVote;
import eu.okaeri.sdk.openvote.model.list.OpenVoteListVoteError;
import eu.okaeri.sdk.openvote.model.list.OpenVoteListVoteSuccess;
import eu.okaeri.sdk.openvote.model.server.OpenVoteServerVote;
import eu.okaeri.sdk.openvote.model.server.OpenVoteServerVoteCheckRequest;
import eu.okaeri.sdk.openvote.model.server.OpenVoteServerVoteCheckResult;
import eu.okaeri.sdk.openvote.model.server.OpenVoteServerVoteStartRequest;
import eu.okaeri.sdk.openvote.model.vote.OpenVoteError;
import kong.unirest.Config;

import java.util.UUID;

public class OpenVoteClient extends OkaeriSdkClient {

    public static final String DEFAULT_BASE_URL = "https://api.openvote.okaeri.cloud";
    public static final int DEFAULT_TIMEOUT = 5000;

    public OpenVoteClient() {
        this(
            resolveBaseUrl("OKAERI_SDK_OPENVOTE_BASE_PATH", DEFAULT_BASE_URL),
            resolveTimeout("OKAERI_SDK_TIMEOUT", DEFAULT_TIMEOUT)
        );
    }

    public OpenVoteClient(String baseUrl) {
        this(
            resolveBaseUrl("OKAERI_SDK_OPENVOTE_BASE_PATH", baseUrl),
            resolveTimeout("OKAERI_SDK_TIMEOUT", DEFAULT_TIMEOUT)
        );
    }

    public OpenVoteClient(String baseUrl, int timeout) {
        super(new Config()
            .socketTimeout(timeout)
            .connectTimeout(timeout)
            .defaultBaseUrl(baseUrl)
        );
    }

    public OpenVoteServerVote postServerVoteNew(OpenVoteServerVoteStartRequest request) throws OpenVoteException {
        return super.getUnirest()
            .post("/v1/server/vote/new")
            .body(request)
            .asObject(OpenVoteServerVote.class)
            .ifFailure(OpenVoteError.class, OpenVoteError.CONSUMER)
            .getBody();
    }

    public OpenVoteServerVoteCheckResult postServerVoteCheck(OpenVoteServerVoteCheckRequest request) throws OpenVoteException {
        return super.getUnirest()
            .post("/v1/server/vote/check")
            .body(request)
            .asObject(OpenVoteServerVoteCheckResult.class)
            .ifFailure(OpenVoteError.class, OpenVoteError.CONSUMER)
            .getBody();
    }

    public OpenVoteListVote postListSuccess(UUID listVoteId, String key) throws OpenVoteException {
        return this.postListSuccess(listVoteId, new OpenVoteListVoteSuccess(key));
    }

    public OpenVoteListVote postListSuccess(UUID listVoteId, OpenVoteListVoteSuccess success) throws OpenVoteException {
        return super.getUnirest()
            .post("/v1/list/vote/success/" + listVoteId)
            .body(success)
            .asObject(OpenVoteListVote.class)
            .ifFailure(OpenVoteError.class, OpenVoteError.CONSUMER)
            .getBody();
    }

    public OpenVoteListVote postListError(UUID listVoteId, String key, String errorCode, String errorMessage) throws OpenVoteException {
        return this.postListError(listVoteId, new OpenVoteListVoteError(key, errorCode, errorMessage));
    }

    public OpenVoteListVote postListError(UUID listVoteId, OpenVoteListVoteError error) throws OpenVoteException {
        return super.getUnirest()
            .post("/v1/list/vote/error/" + listVoteId)
            .body(error)
            .asObject(OpenVoteListVote.class)
            .ifFailure(OpenVoteError.class, OpenVoteError.CONSUMER)
            .getBody();
    }

    public OpenVoteListVote getListVote(UUID listVoteId) throws OpenVoteException {
        return super.getUnirest()
            .get("/v1/list/vote/" + listVoteId)
            .asObject(OpenVoteListVote.class)
            .ifFailure(OpenVoteError.class, OpenVoteError.CONSUMER)
            .getBody();
    }
}
