package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Route implements Serializable {
    boolean hasTollRoad;
    boolean hasBridge;
    BoundingBox boundingBox;
    double distance;
    boolean hasTimedRestriction;
    boolean hasTunnel;
    boolean hasHighway;
    ArrayList<Object> computedWaypoints;
    RouteError routeError;
    String formattedTime;
    String sessionId;
    boolean hasAccessRestriction;
    int realTime;
    boolean hasSeasonalClosure;
    boolean hasCountryCross;
    double fuelUsed;
    ArrayList<Leg> legs;
    Options options;
    ArrayList<Location> locations;
    int time;
    boolean hasUnpaved;
    ArrayList<Integer> locationSequence;
    boolean hasFerry;
}

