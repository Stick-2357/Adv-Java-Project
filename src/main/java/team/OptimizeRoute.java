package team;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import team.jsonobjects.Location;
import team.jsonobjects.Root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OptimizeRoute {
    public static void main(String[] args) throws IOException {
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(1, "joe", "", "", "117 N Eastglen DR, MO"));
        profiles.add(new Profile(2, "", "", "", "Kansas City, MO"));
        System.out.println(getOptimizedRoutes(profiles));
    }

    public static List<Location> getOptimizedRoutes(ArrayList<Profile> inputProfiles) throws IOException {
        ArrayList<String> inputLocations = (ArrayList<String>) inputProfiles.stream().map(profile -> profile.getAddress().replace(" ", "")).collect(Collectors.toList());

        // build http request
        String mapquestKey = PropertiesUtil.getProperties().getProperty("mapquestkey");
        String stringURL = "https://www.mapquestapi.com/directions/v2/optimizedroute?key=" + mapquestKey + "&json={\"locations\":[\"" + String.join("\",\"", inputLocations) + "\"]}";
        System.out.println(stringURL);

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
        } else {
            throw new IOException("Bad return value: " + status);
        }
    }
}
