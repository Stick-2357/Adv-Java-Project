import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OptimizeRoute {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(getOptimizedRoutes(new String[]{"Denver,CO", "Westminster,CO", "Boulder,CO"})));
    }

    public static String[] getOptimizedRoutes(String[] inputLocations) throws IOException {
        // build http request
        String stringURL = Arrays.stream(inputLocations, 1, inputLocations.length).map(inputLocation -> ",\"" + inputLocation + "\"").collect(Collectors.joining("", "http://www.mapquestapi.com/directions/v2/optimizedroute?key=e06v9nqvPG3ALqr1Tet0bCgNSduBDdRx&json={\"locations\":[" + "\"" + inputLocations[0] + "\"", "]}"));

        // call http request
        HttpURLConnection connection = (HttpURLConnection) new URL(stringURL).openConnection();
        int status = connection.getResponseCode();

        if (status == 200) { // if http returned correctly
            // read all the json as a string
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            connection.disconnect();
            StringBuilder content = new StringBuilder();
            in.lines().forEach(content::append);
            in.close();

            // get locations
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
            return locationsLngLat;
        }
        return new String[0];
    }
}
