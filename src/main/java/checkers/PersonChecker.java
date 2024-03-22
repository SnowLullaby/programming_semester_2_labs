package checkers;

import models.*;

public class PersonChecker {
    public static boolean checkPerson(Person person){
        return checkID(person.getId())
                && checkName(person.getName())
                && checkCoordinates(person.getCoordinates())
                && checkCreationDate(person.getCreationDate())
                && checkHeight(person.getHeight())
                && checkWeight(person.getWeight())
                && checkEyeColor(person.getEyeColor())
                && checkNationality(person.getNationality())
                && checkLocation(person.getLocation());
    }

    private static boolean checkLocation(Location location) {
        return LocationChecker.checkLocation(location);
    }

    private static boolean checkNationality(Country nationality) {
        return nationality != null;
    }

    private static boolean checkEyeColor(Color eyeColor) {
        return eyeColor != null;
    }

    private static boolean checkWeight(Float weight) {
        return weight != null && weight > 0 ;
    }

    private static boolean checkHeight(Integer height) {
        return height != null && height > 0 ;
    }

    private static boolean checkCreationDate(String creationDate) {
        return creationDate != null;
    }

    private static boolean checkCoordinates(Coordinates coordinates) {
        return CoordinatesChecker.checkCoordinates(coordinates);
    }

    private static boolean checkName(String name) {
        return name != null && !name.isEmpty();
    }

    private static boolean checkID(Long id) {
        return id != 0 && id > 0;
    }
}
