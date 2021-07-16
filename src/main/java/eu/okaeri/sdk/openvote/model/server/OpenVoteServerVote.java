package eu.okaeri.sdk.openvote.model.server;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class OpenVoteServerVote implements Serializable {
    private final String url;
    private final UUID serverVoteId;
}
