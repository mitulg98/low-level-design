package org.example;

public class GPSNavigator {
    private final String route;

    public GPSNavigator() {
        this.route = "Hello guys! How are you.";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
