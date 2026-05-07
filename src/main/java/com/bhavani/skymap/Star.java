package com.bhavani.skymap;

public class Star {
    public String name;
    public double ra;
    public double dec;
    public double mag;

    public Star(String name, double ra, double dec, double mag) {
        this.name = name;
        this.ra = ra;
        this.dec = dec;
        this.mag = mag;
    }
}