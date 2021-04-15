package eu.okaeri.sdk.openvote.model.list;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenVoteListVoteError {
    @SerializedName("key") private String key;
    @SerializedName("error_code") private String errorCode;
    @SerializedName("error_message") private String errorMessage;
}
