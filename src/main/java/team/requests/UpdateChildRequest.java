package team.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.Profile;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateChildRequest extends AbstractRequest {
    Profile profile;

    public UpdateChildRequest(Profile profile) {
        requestName = "Update Child";
        this.profile = profile;
    }
}
