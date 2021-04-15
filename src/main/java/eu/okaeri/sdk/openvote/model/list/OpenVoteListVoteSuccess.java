package eu.okaeri.sdk.openvote.model.list;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenVoteListVoteSuccess {
    @SerializedName("key") private String key;
}
