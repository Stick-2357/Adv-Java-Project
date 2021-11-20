package route;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import route.objects.Location;
import route.objects.Root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OptimizeRoute {
    public static void main(String[] args) throws IOException {
        System.out.println(getOptimizedRoutes(new String[]{"Denver,CO", "Westminster,CO", "Boulder,CO"}));
    }

    public static List<Location> getOptimizedRoutes(String[] inputLocations) throws IOException {
        // build http request
        String mapquestKey = "e06v9nqvPG3ALqr1Tet0bCgNSduBDdRx"; // TODO: Move to config file
        String stringURL = "https://www.mapquestapi.com/directions/v2/optimizedroute?key=" + mapquestKey + "&json={\"locations\":[\"" + String.join("\",\"", inputLocations) + "\"]}";

        // call http request
        HttpURLConnection connection = (HttpURLConnection) new URL(stringURL).openConnection();
        int status = connection.getResponseCode();

        if (status == 200) { // if http returned correctly
            // read input to Google Json library
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            Root root = gson.fromJson(in, Root.class);

            in.close();
            connection.disconnect();

            return root.getRoute().getLocations();
        }
        return new ArrayList<>();
    }
}
