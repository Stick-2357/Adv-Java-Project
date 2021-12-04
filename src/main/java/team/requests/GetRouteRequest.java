package team.requests;

import lombok.Data;
import team.Profile;

import java.util.ArrayList;

@Data
public class GetRouteRequest extends AbstractRequest {
    ArrayList<Profile> children;

    public GetRouteRequest(ArrayList<Profile> children) {
        this.children = children;
        this.requestName = "Get Route";
    }
}
