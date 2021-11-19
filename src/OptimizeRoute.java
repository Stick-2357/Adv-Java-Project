import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class OptimizeRoute {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(getOptimizedRoutes(new String[]{"Denver,CO", "Westminster,CO", "Boulder,CO"})));
    }

    public static String[] getOptimizedRoutes(String[] inputLocations) throws IOException {
        StringBuilder stringURL = new StringBuilder("http://www.mapquestapi.com/directions/v2/optimizedroute?key=e06v9nqvPG3ALqr1Tet0bCgNSduBDdRx&json={\"locations\":[");
        stringURL.append("\"").append(inputLocations[0]).append("\"");
        for (int i = 1; i < inputLocations.length; i++) {
            String inputLocation = inputLocations[i];
            stringURL.append(",\"").append(inputLocation).append("\"");
        }
        stringURL.append("]}");

        URL url = new URL(stringURL.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        int status = con.getResponseCode();

        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) content.append(inputLine);
            in.close();
            int indexOfLocations = content.indexOf("\"locations\":");
            String locationsJSON = content.substring(indexOfLocations, content.indexOf("]", indexOfLocations) + 1);
            int lastIndex = 0;
            String[] locationsLngLat = new String[inputLocations.length];
            for (int i = 0; i < locationsLngLat.length; i++) {
                int indexOfNextLatLngStart = locationsJSON.indexOf("\"latLng\":", lastIndex);
                int indexOfNextLatLngEnd = locationsJSON.indexOf("}}", indexOfNextLatLngStart) + 2;
                locationsLngLat[i] = locationsJSON.substring(indexOfNextLatLngStart, indexOfNextLatLngEnd);
                lastIndex = indexOfNextLatLngEnd;
            }
            con.disconnect();
            return locationsLngLat;
        }
        return new String[0];
    }
}
