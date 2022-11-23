package com.example.Try;

public class Travelinfo {
    String guide;
    String health;
    String sec;
    String county;
    String max;

    public Travelinfo(String guide, String health, String sec, String county, String max) {
        this.guide = guide;
        this.health = health;
        this.sec = sec;
        this.county = county;
        this.max = max;
    }

    public String getGuide() {
        return guide;
    }

    public String getHealth() {
        return health;
    }

    public String getSec() {
        return sec;
    }

    public String getCounty() {
        return county;
    }

    public String getMax() {
        return max;
    }
}
