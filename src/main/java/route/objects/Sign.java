package route.objects;

public class Sign {
    String extraText;
    String text;
    int type;
    String url;
    int direction;

    @Override
    public String toString() {
        return "Sign{" +
                "extraText='" + extraText + '\'' +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", direction=" + direction +
                '}';
    }
}
