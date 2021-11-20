package route.objects;

public class RouteError {
    int errorCode;
    String message;

    @Override
    public String toString() {
        return "RouteError{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }
}
