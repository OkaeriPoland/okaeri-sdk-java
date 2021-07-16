package eu.okaeri.sdk.openvote.model.vote;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OpenVoteVoteIdentifier implements Serializable {
    private final String type;
    private final String value;
}
