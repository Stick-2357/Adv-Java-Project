package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class DisplayLatLng implements Serializable {
    double lng;
    double lat;
}
