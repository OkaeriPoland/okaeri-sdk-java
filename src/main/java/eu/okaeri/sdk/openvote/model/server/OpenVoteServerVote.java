package eu.okaeri.sdk.openvote.model.server;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class OpenVoteServerVote implements Serializable {
    @SerializedName("url") private final String url;
    @SerializedName("server_vote_id") private final UUID serverVoteId;
}
