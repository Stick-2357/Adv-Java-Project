package route.objects;

import java.util.List;

public class Options {
    List<Object> arteryWeights;
    int cyclingRoadFactor;
    int timeType;
    boolean useTraffic;
    boolean returnLinkDirections;
    boolean countryBoundaryDisplay;
    boolean enhancedNarrative;
    String locale;
    List<Object> tryAvoidLinkIds;
    int drivingStyle;
    boolean doReverseGeocode;
    int generalize;
    List<Object> mustAvoidLinkIds;
    boolean sideOfStreetDisplay;
    String routeType;
    boolean avoidTimedConditions;
    int routeNumber;
    String shapeFormat;
    int maxWalkingDistance;
    boolean destinationManeuverDisplay;
    int transferPenalty;
    String narrativeType;
    int walkingSpeed;
    int urbanAvoidFactor;
    boolean stateBoundaryDisplay;
    String unit;
    int highwayEfficiency;
    int maxLinkId;
    int maneuverPenalty;
    List<Object> avoidTripIds;
    int filterZoneFactor;
    String manmaps;

    @Override
    public String toString() {
        return "Options{" +
                "arteryWeights=" + arteryWeights +
                ", cyclingRoadFactor=" + cyclingRoadFactor +
                ", timeType=" + timeType +
                ", useTraffic=" + useTraffic +
                ", returnLinkDirections=" + returnLinkDirections +
                ", countryBoundaryDisplay=" + countryBoundaryDisplay +
                ", enhancedNarrative=" + enhancedNarrative +
                ", locale='" + locale + '\'' +
                ", tryAvoidLinkIds=" + tryAvoidLinkIds +
                ", drivingStyle=" + drivingStyle +
                ", doReverseGeocode=" + doReverseGeocode +
                ", generalize=" + generalize +
                ", mustAvoidLinkIds=" + mustAvoidLinkIds +
                ", sideOfStreetDisplay=" + sideOfStreetDisplay +
                ", routeType='" + routeType + '\'' +
                ", avoidTimedConditions=" + avoidTimedConditions +
                ", routeNumber=" + routeNumber +
                ", shapeFormat='" + shapeFormat + '\'' +
                ", maxWalkingDistance=" + maxWalkingDistance +
                ", destinationManeuverDisplay=" + destinationManeuverDisplay +
                ", transferPenalty=" + transferPenalty +
                ", narrativeType='" + narrativeType + '\'' +
                ", walkingSpeed=" + walkingSpeed +
                ", urbanAvoidFactor=" + urbanAvoidFactor +
                ", stateBoundaryDisplay=" + stateBoundaryDisplay +
                ", unit='" + unit + '\'' +
                ", highwayEfficiency=" + highwayEfficiency +
                ", maxLinkId=" + maxLinkId +
                ", maneuverPenalty=" + maneuverPenalty +
                ", avoidTripIds=" + avoidTripIds +
                ", filterZoneFactor=" + filterZoneFactor +
                ", manmaps='" + manmaps + '\'' +
                '}';
    }
}
