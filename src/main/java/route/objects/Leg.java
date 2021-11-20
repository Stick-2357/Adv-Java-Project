package route.objects;

import java.util.List;

public class Leg {
    public boolean hasTollRoad;
    public boolean hasBridge;
    public String destNarrative;
    public double distance;
    public boolean hasTimedRestriction;
    public boolean hasTunnel;
    public boolean hasHighway;
    public int index;
    public String formattedTime;
    public int origIndex;
    public boolean hasAccessRestriction;
    public boolean hasSeasonalClosure;
    public boolean hasCountryCross;
    public List<List<Object>> roadGradeStrategy;
    public int destIndex;
    public int time;
    public boolean hasUnpaved;
    public String origNarrative;
    public List<Maneuver> maneuvers;
    public boolean hasFerry;
}
