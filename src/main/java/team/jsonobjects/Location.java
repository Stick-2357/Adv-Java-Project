package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class Location implements Serializable  {
    boolean dragPoint;
    DisplayLatLng displayLatLng;
    String adminArea4;
    String adminArea5;
    String postalCode;
    String adminArea1;
    String adminArea3;
    String type;
    String sideOfStreet;
    String geocodeQualityCode;
    String adminArea4Type;
    int linkId;
    String street;
    String adminArea5Type;
    String geocodeQuality;
    String adminArea1Type;
    String adminArea3Type;
    LatLng latLng;

//    public String getCleanAddress() {
//        return
//    }
}
