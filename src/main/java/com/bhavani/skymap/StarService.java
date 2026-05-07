package com.bhavani.skymap;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StarService {

    // 🔹 Load all stars
    public static List<Star> loadStars(String fileName) {
    List<Star> stars = new ArrayList<>();

    try {
        InputStream is = StarService.class
                .getClassLoader()
                .getResourceAsStream("hygdata_v37.csv");

        if (is == null) {
            System.out.println("CSV file not found!");
            return stars;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",", -1);

            if (data.length <= 13) continue;

            String name = data[6];
            if (name == null || name.isEmpty()) continue;

            try {
                if (data[7].isEmpty() || data[8].isEmpty() || data[13].isEmpty()) continue;

                double ra = Double.parseDouble(data[7]);
                double dec = Double.parseDouble(data[8]);
                double mag = Double.parseDouble(data[13]);

                stars.add(new Star(name, ra, dec, mag));
            } catch (Exception e) {
                continue;
            }
        }

        br.close();

    } catch (Exception e) {
        System.out.println("Error loading file: " + e.getMessage());
    }

    return stars;
}

    // 🔹 Filter visible stars
    public static List<Star> getVisibleStars(List<Star> stars, double latitude) {

    List<Star> visible = new ArrayList<>();

    for (Star s : stars) {

        // Northern hemisphere
        if (latitude > 30) {

            if (s.dec > 20 && s.mag < 2.0) {
                visible.add(s);
            }

        }

        // Southern hemisphere
        else if (latitude < -30) {

            if (s.dec < -20 && s.mag < 2.0) {
                visible.add(s);
            }

        }

        // Equator region
        else {

            if (Math.abs(s.dec) <= 30 && s.mag < 2.0) {
                visible.add(s);
            }
        }
    }

    return visible;
}

    // 🔹 Sort stars
    public static void sortByBrightness(List<Star> stars) {
        Collections.sort(stars, (a, b) -> Double.compare(a.mag, b.mag));
    }
}