package route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import route.objects.Location;
import route.objects.ReturnObject;

public class OptimizeRoute {
    public static void main(String[] args) throws IOException {
        System.out.println(getOptimizedRoutes(new String[]{"Denver,CO", "Westminster,CO", "Boulder,CO"}));
    }

    public static List<Location> getOptimizedRoutes(String[] inputLocations) throws IOException {
        // build http request
        String stringURL = "https://www.mapquestapi.com/directions/v2/optimizedroute?key=e06v9nqvPG3ALqr1Tet0bCgNSduBDdRx&json={\"locations\":[\"" + String.join("\",\"", inputLocations)  + "\"]}";

        // call http request
        HttpURLConnection connection = (HttpURLConnection) new URL(stringURL).openConnection();
        int status = connection.getResponseCode();

        if (status == 200) { // if http returned correctly
            // read input to Google Json library
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            ReturnObject returnObject = gson.fromJson(in, ReturnObject.class);

            in.close();
            connection.disconnect();

            return returnObject.getRoute().getLocations();
        }
        return new ArrayList<>();
    }
}
