package eu.okaeri.sdk.openvote.model.server;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.UUID;

@Data
public class OpenVoteServerVoteCheckResult {
    @SerializedName("votes") private final Map<UUID, String> votes;
}
