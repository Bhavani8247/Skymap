package com.bhavani.skymap;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StarController {

    @GetMapping("/stars")
    public List<Star> getStars(@RequestParam double lat) {

        // 🔥 Debug print
        System.out.println("Latitude received: " + lat);

        List<Star> stars = StarService.loadStars("hygdata_v37.csv");

        List<Star> visible = StarService.getVisibleStars(stars, lat);

        StarService.sortByBrightness(visible);

        return visible.subList(0, Math.min(10, visible.size()));
    }
}