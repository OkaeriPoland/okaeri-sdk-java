package eu.okaeri.sdk.openvote.model.server;

import eu.okaeri.sdk.openvote.model.vote.OpenVoteVoteIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenVoteServerVoteStartRequest implements Serializable {
    private String list;
    private UUID statsId;
    private int singleCooldown;
    private int generalCooldown;
    private boolean passIdentifiers;
    private List<OpenVoteVoteIdentifier> identifiers;
    private String server;
    private String game;
    private String lang;
    private String background;
}
