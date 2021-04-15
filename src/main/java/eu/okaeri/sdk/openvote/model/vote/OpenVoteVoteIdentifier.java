package eu.okaeri.sdk.openvote.model.vote;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenVoteVoteIdentifier {
    @SerializedName("type") private final String type;
    @SerializedName("value") private final String value;
}
