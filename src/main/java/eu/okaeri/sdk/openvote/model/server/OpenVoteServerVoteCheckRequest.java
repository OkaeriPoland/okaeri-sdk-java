package eu.okaeri.sdk.openvote.model.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OpenVoteServerVoteCheckRequest implements Serializable {
    private List<UUID> votes;
}
