package eu.okaeri.sdk.openvote.model.vote;

import lombok.AllArgsConstructor;
import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
@AllArgsConstructor
public class OpenVoteVoteIdentifier {
    @SerializedName("type") private final String type;
    @SerializedName("value") private final String value;
}
