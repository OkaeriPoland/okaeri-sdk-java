package eu.okaeri.sdk.openvote.model.list;

import com.google.gson.annotations.SerializedName;
import eu.okaeri.sdk.openvote.model.vote.OpenVoteVoteIdentifier;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OpenVoteListVote implements Serializable {
    @SerializedName("list") private final String list;
    @SerializedName("server") private final String server;
    @SerializedName("game") private final String game;
    @SerializedName("lang") private final String lang;
    @SerializedName("background") private final String background;
    @SerializedName("background_type") private final String backgroundType;
    @SerializedName("identifiers") private final List<OpenVoteVoteIdentifier> identifiers;
    @SerializedName("identifiers_hash") private final String identifiersHash;
}
