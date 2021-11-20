package route.objects;

public class Root {
    Route route;
    Info info;

    @Override
    public String toString() {
        return "Root{" +
                "route=" + route +
                ", info=" + info +
                '}';
    }

    public Route getRoute() {
        return route;
    }
}
