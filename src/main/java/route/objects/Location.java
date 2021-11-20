package route.objects;

public class Location {
    public boolean dragPoint;
    public DisplayLatLng displayLatLng;
    public String adminArea4;
    public String adminArea5;
    public String postalCode;
    public String adminArea1;
    public String adminArea3;
    public String type;
    public String sideOfStreet;
    public String geocodeQualityCode;
    public String adminArea4Type;
    public int linkId;
    public String street;
    public String adminArea5Type;
    public String geocodeQuality;
    public String adminArea1Type;
    public String adminArea3Type;
    public LatLng latLng;

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
