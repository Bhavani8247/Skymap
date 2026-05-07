package com.bhavani.skymap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

class LocationService {

    public static Location getLocation() {
        try {
            URI uri = new URI("http://ip-api.com/json");
            URL url = uri.toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String result = response.toString();

            // 🔥 Extract values
            String city = extract(result, "\"city\":\"", "\"");
            double lat = Double.parseDouble(extract(result, "\"lat\":", ","));
            double lon = Double.parseDouble(extract(result, "\"lon\":", ","));

            return new Location(city, lat, lon);

        } catch (Exception e) {
            System.out.println("Location error: " + e.getMessage());
        }

        return new Location("Unknown", 0.0, 0.0);
    }

    // 🔧 Helper method
    private static String extract(String text, String start, String end) {
        int i = text.indexOf(start);
        if (i == -1) return "";

        i += start.length();
        int j = text.indexOf(end, i);

        return text.substring(i, j);
    }
}