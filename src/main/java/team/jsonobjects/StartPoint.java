package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class StartPoint implements Serializable {
    double lng;
    double lat;
}
