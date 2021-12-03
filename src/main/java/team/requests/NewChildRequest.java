package team.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.Profile;

@EqualsAndHashCode(callSuper = true)
@Data
public class NewChildRequest extends AbstractRequest {
    String requestName = "New Child";
    Profile profile;

    public NewChildRequest(Profile profile) {
        this.profile = profile;
    }
}
