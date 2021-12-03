package team.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.Profile;

@EqualsAndHashCode(callSuper = true)
@Data
public class NewChildRequest extends AbstractRequest {
    Profile profile;

    public NewChildRequest(Profile profile) {
        requestName = "New Child";
        this.profile = profile;
    }
}
