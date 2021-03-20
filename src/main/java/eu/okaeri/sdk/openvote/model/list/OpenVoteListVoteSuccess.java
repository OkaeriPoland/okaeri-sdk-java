package eu.okaeri.sdk.openvote.model.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
@AllArgsConstructor
public class OpenVoteListVoteSuccess {
    @SerializedName("key") private String key;
}
