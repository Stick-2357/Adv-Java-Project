package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Maneuver implements Serializable {
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
}
