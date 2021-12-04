package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class Lr implements Serializable {
    double lng;
    double lat;
}
