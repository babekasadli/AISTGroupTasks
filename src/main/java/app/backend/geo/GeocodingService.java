package app.backend.geo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@ApplicationScoped
public class GeocodingService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public String search(String query) {
        String jsonResponse = performRequest("https://nominatim.md7.info/search?q=" + query + "&format=jsonv2");
        if (jsonResponse != null) {
            logRequest("search", query, jsonResponse);
            persistPlaces(jsonResponse, true);
        } else {
            entityManager.getTransaction().setRollbackOnly();
        }
        return jsonResponse;
    }

    @Transactional
    public String reverse(String latitude, String longitude) {
        String jsonResponse = performRequest("https://nominatim.md7.info/reverse?lat=" + latitude + "&lon=" + longitude + "&format=jsonv2");
        if (jsonResponse != null) {
            logRequest("reverse", "lat=" + latitude + "&lon=" + longitude, jsonResponse);
            persistPlaces(jsonResponse, false);
        } else {
            entityManager.getTransaction().setRollbackOnly();
        }
        return jsonResponse;
    }

    private String performRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            Scanner scanner = new Scanner(url.openStream(), "UTF-8");
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();
            return jsonResponse.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void logRequest(String type, String parameters, String response) {
        Log log = new Log(type, parameters, response);
        try {
            entityManager.persist(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void persistPlaces(String jsonResponse, boolean isArray) {
        if (isArray) {
            JsonArray jsonArray = Json.createReader(new StringReader(jsonResponse)).readArray();
            for (JsonValue jsonValue : jsonArray) {
                JsonObject jsonObject = jsonValue.asJsonObject();
                persistPlace(jsonObject);
            }
        } else {
            JsonObject jsonObject = Json.createReader(new StringReader(jsonResponse)).readObject();
            persistPlace(jsonObject);
        }
    }

    private void persistPlace(JsonObject jsonObject) {
        String displayName = jsonObject.getString("display_name", null);
        String lat = jsonObject.getString("lat", null);
        String lon = jsonObject.getString("lon", null);
        String category = jsonObject.getString("category", null);

        if (displayName != null && lat != null && lon != null && category != null) {
            Place place = new Place();
            place.setDisplayName(displayName);
            place.setLat(lat);
            place.setLon(lon);
            place.setCategory(category);
            entityManager.persist(place);
        }
    }
}
