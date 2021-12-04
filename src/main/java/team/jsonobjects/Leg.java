package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Leg implements Serializable {
    boolean hasTollRoad;
    boolean hasBridge;
    String destNarrative;
    double distance;
    boolean hasTimedRestriction;
    boolean hasTunnel;
    boolean hasHighway;
    int index;
    String formattedTime;
    int origIndex;
    boolean hasAccessRestriction;
    boolean hasSeasonalClosure;
    boolean hasCountryCross;
    List<List<Object>> roadGradeStrategy;
    int destIndex;
    int time;
    boolean hasUnpaved;
    String origNarrative;
    List<Maneuver> maneuvers;
    boolean hasFerry;
}
