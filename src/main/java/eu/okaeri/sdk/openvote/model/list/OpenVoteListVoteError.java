package eu.okaeri.sdk.openvote.model.list;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OpenVoteListVoteError implements Serializable {
    @SerializedName("key") private String key;
    @SerializedName("error_code") private String errorCode;
    @SerializedName("error_message") private String errorMessage;
}
