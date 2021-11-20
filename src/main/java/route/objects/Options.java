package route.objects;

import lombok.Data;

import java.util.List;

@Data
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

}
