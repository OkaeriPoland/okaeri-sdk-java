package eu.okaeri.sdk.openvote.model.list;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OpenVoteListVoteSuccess implements Serializable {
    @SerializedName("key") private String key;
}
