package route.objects;

public class Location {
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

    public LatLng getLatLng() {
        return latLng;
    }

    @Override
    public String toString() {
        return "Location{" +
                "dragPoint=" + dragPoint +
                ", displayLatLng=" + displayLatLng +
                ", adminArea4='" + adminArea4 + '\'' +
                ", adminArea5='" + adminArea5 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", adminArea1='" + adminArea1 + '\'' +
                ", adminArea3='" + adminArea3 + '\'' +
                ", type='" + type + '\'' +
                ", sideOfStreet='" + sideOfStreet + '\'' +
                ", geocodeQualityCode='" + geocodeQualityCode + '\'' +
                ", adminArea4Type='" + adminArea4Type + '\'' +
                ", linkId=" + linkId +
                ", street='" + street + '\'' +
                ", adminArea5Type='" + adminArea5Type + '\'' +
                ", geocodeQuality='" + geocodeQuality + '\'' +
                ", adminArea1Type='" + adminArea1Type + '\'' +
                ", adminArea3Type='" + adminArea3Type + '\'' +
                ", latLng=" + latLng +
                '}';
    }
}
