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
import kong.unirest.Unirest;

import java.util.UUID;

public class OpenVoteClient extends OkaeriSdkClient {

    public OpenVoteClient() {
        this(
                resolveBaseUrl("OKAERI_SDK_OPENVOTE_BASE_PATH", "https://openvote-api.okaeri.eu"),
                resolveTimeout("OKAERI_SDK_TIMEOUT", 5000)
        );
    }

    public OpenVoteClient(String baseUrl, int timeout) {
        super(Unirest.config()
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
