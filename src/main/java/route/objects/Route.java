package route.objects;

import java.util.List;

public class Route{
    public boolean hasTollRoad;
    public boolean hasBridge;
    public BoundingBox boundingBox;
    public double distance;
    public boolean hasTimedRestriction;
    public boolean hasTunnel;
    public boolean hasHighway;
    public List<Object> computedWaypoints;
    public RouteError routeError;
    public String formattedTime;
    public String sessionId;
    public boolean hasAccessRestriction;
    public int realTime;
    public boolean hasSeasonalClosure;
    public boolean hasCountryCross;
    public double fuelUsed;
    public List<Leg> legs;
    public Options options;
    public List<Location> locations;
    public int time;
    public boolean hasUnpaved;
    public List<Integer> locationSequence;
    public boolean hasFerry;

    public List<Location> getLocations() {
        return locations;
    }
}

