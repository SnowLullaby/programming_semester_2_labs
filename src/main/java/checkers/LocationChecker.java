package checkers;

import models.Location;

public class LocationChecker {
    public static boolean checkLocation(Location location) {
        return checkX(location.getX())
                && checkY(location.getY())
                && checkZ(location.getZ());
    }

    private static boolean checkZ(Integer z) {
        return z != null;
    }

    private static boolean checkY(float y) {
        return true;
    }

    private static boolean checkX(Double x) {
        return x != null;
    }
}
