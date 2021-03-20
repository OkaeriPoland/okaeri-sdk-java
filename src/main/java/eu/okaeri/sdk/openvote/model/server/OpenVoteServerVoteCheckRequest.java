package eu.okaeri.sdk.openvote.model.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OpenVoteServerVoteCheckRequest {
    @SerializedName("votes") private List<UUID> votes;
}
