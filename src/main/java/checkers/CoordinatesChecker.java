package checkers;

import models.Coordinates;

public class CoordinatesChecker {
    public static boolean checkCoordinates(Coordinates coordinates) {
        return checkX(coordinates.getX()) && checkY(coordinates.getY());
    }

    public static boolean checkY(Double y) {
        return y != null && y < 933;
    }

    public static boolean checkX(Double x) {
        return x != null;
    }
}
