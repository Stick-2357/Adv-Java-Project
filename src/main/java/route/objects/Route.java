package route.objects;

import lombok.Data;

import java.util.List;

@Data
public class Route {
    boolean hasTollRoad;
    boolean hasBridge;
    BoundingBox boundingBox;
    double distance;
    boolean hasTimedRestriction;
    boolean hasTunnel;
    boolean hasHighway;
    List<Object> computedWaypoints;
    RouteError routeError;
    String formattedTime;
    String sessionId;
    boolean hasAccessRestriction;
    int realTime;
    boolean hasSeasonalClosure;
    boolean hasCountryCross;
    double fuelUsed;
    List<Leg> legs;
    Options options;
    List<Location> locations;
    int time;
    boolean hasUnpaved;
    List<Integer> locationSequence;
    boolean hasFerry;
}

