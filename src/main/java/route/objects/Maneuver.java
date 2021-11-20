package route.objects;

import java.util.List;

public class Maneuver {
    double distance;
    List<String> streets;
    String narrative;
    int turnType;
    StartPoint startPoint;
    int index;
    String formattedTime;
    String directionName;
    List<Object> maneuverNotes;
    List<Object> linkIds;
    List<Sign> signs;
    String mapUrl;
    String transportMode;
    int attributes;
    int time;
    String iconUrl;
    int direction;

    @Override
    public String toString() {
        return "Maneuver{" +
                "distance=" + distance +
                ", streets=" + streets +
                ", narrative='" + narrative + '\'' +
                ", turnType=" + turnType +
                ", startPoint=" + startPoint +
                ", index=" + index +
                ", formattedTime='" + formattedTime + '\'' +
                ", directionName='" + directionName + '\'' +
                ", maneuverNotes=" + maneuverNotes +
                ", linkIds=" + linkIds +
                ", signs=" + signs +
                ", mapUrl='" + mapUrl + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", attributes=" + attributes +
                ", time=" + time +
                ", iconUrl='" + iconUrl + '\'' +
                ", direction=" + direction +
                '}';
    }
}
