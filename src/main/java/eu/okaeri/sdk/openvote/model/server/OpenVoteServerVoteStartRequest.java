package eu.okaeri.sdk.openvote.model.server;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("list") private String list;
    @SerializedName("stats_id") private UUID statsId;
    @SerializedName("single_cooldown") private int singleCooldown;
    @SerializedName("general_cooldown") private int generalCooldown;
    @SerializedName("pass_identifiers") private boolean passIdentifiers;
    @SerializedName("identifiers") private List<OpenVoteVoteIdentifier> identifiers;
    @SerializedName("server") private String server;
    @SerializedName("game") private String game;
    @SerializedName("lang") private String lang;
    @SerializedName("background") private String background;
}
