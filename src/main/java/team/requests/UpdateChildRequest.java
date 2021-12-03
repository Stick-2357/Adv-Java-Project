package team.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team.Profile;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateChildRequest extends AbstractRequest {
    String requestName = "Update Child";
    Profile profile;

    public UpdateChildRequest(Profile profile) {
        this.profile = profile;
    }
}
