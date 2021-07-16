package eu.okaeri.sdk.openvote.model.list;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OpenVoteListVoteSuccess implements Serializable {
    private String key;
}
