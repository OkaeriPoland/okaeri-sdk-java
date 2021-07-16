package eu.okaeri.sdk.openvote.model.list;

import eu.okaeri.sdk.openvote.model.vote.OpenVoteVoteIdentifier;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OpenVoteListVote implements Serializable {
    private final String list;
    private final String server;
    private final String game;
    private final String lang;
    private final String background;
    private final String backgroundType;
    private final List<OpenVoteVoteIdentifier> identifiers;
    private final String identifiersHash;
}
