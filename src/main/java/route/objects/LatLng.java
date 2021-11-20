package route.objects;

public class LatLng {
    public double lng;
    public double lat;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
