package eu.okaeri.sdk.openvote.model.server;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Data
public class OpenVoteServerVoteCheckResult implements Serializable {
    @SerializedName("votes") private final Map<UUID, String> votes;
}
