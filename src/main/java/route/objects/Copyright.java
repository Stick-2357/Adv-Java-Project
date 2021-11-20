package route.objects;

public class Copyright {
    String imageAltText;
    String imageUrl;
    String text;

    @Override
    public String toString() {
        return "Copyright{" +
                "imageAltText='" + imageAltText + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
