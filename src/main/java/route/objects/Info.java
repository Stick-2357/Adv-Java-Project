package route.objects;

import java.util.List;

public class Info {
    int statuscode;
    Copyright copyright;
    List<Object> messages;

    @Override
    public String toString() {
        return "Info{" +
                "statuscode=" + statuscode +
                ", copyright=" + copyright +
                ", messages=" + messages +
                '}';
    }
}
