package checkers;

import models.Location;

public class LocationChecker {
    public static boolean checkLocation(Location location) {
        return checkX(location.getX())
                && checkY(location.getY())
                && checkZ(location.getZ());
    }

    public static boolean checkZ(Integer z) {
        return z != null;
    }

    public static boolean checkY(float y) {
        return true;
    }

    public static boolean checkX(Double x) {
        return x != null;
    }
}
