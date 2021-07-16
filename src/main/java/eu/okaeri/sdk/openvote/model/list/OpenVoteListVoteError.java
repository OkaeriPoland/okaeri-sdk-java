package eu.okaeri.sdk.openvote.model.list;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OpenVoteListVoteError implements Serializable {
    private String key;
    private String errorCode;
    private String errorMessage;
}
