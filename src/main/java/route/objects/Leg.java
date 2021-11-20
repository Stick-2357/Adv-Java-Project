package route.objects;

import java.util.List;

public class Leg {
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

    @Override
    public String toString() {
        return "Leg{" +
                "hasTollRoad=" + hasTollRoad +
                ", hasBridge=" + hasBridge +
                ", destNarrative='" + destNarrative + '\'' +
                ", distance=" + distance +
                ", hasTimedRestriction=" + hasTimedRestriction +
                ", hasTunnel=" + hasTunnel +
                ", hasHighway=" + hasHighway +
                ", index=" + index +
                ", formattedTime='" + formattedTime + '\'' +
                ", origIndex=" + origIndex +
                ", hasAccessRestriction=" + hasAccessRestriction +
                ", hasSeasonalClosure=" + hasSeasonalClosure +
                ", hasCountryCross=" + hasCountryCross +
                ", roadGradeStrategy=" + roadGradeStrategy +
                ", destIndex=" + destIndex +
                ", time=" + time +
                ", hasUnpaved=" + hasUnpaved +
                ", origNarrative='" + origNarrative + '\'' +
                ", maneuvers=" + maneuvers +
                ", hasFerry=" + hasFerry +
                '}';
    }
}
