package eu.okaeri.sdk.openvote.model.server;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

import java.util.UUID;

@Data
public class OpenVoteServerVote {
    @SerializedName("url") private final String url;
    @SerializedName("server_vote_id") private final UUID serverVoteId;
}
