package route.objects;

import java.util.List;

public class Route{
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

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return "Route{" +
                "hasTollRoad=" + hasTollRoad +
                ", hasBridge=" + hasBridge +
                ", boundingBox=" + boundingBox +
                ", distance=" + distance +
                ", hasTimedRestriction=" + hasTimedRestriction +
                ", hasTunnel=" + hasTunnel +
                ", hasHighway=" + hasHighway +
                ", computedWaypoints=" + computedWaypoints +
                ", routeError=" + routeError +
                ", formattedTime='" + formattedTime + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", hasAccessRestriction=" + hasAccessRestriction +
                ", realTime=" + realTime +
                ", hasSeasonalClosure=" + hasSeasonalClosure +
                ", hasCountryCross=" + hasCountryCross +
                ", fuelUsed=" + fuelUsed +
                ", legs=" + legs +
                ", options=" + options +
                ", locations=" + locations +
                ", time=" + time +
                ", hasUnpaved=" + hasUnpaved +
                ", locationSequence=" + locationSequence +
                ", hasFerry=" + hasFerry +
                '}';
    }
}

