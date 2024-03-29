package commandService;

import checkers.*;
import models.*;
import java.util.*;
import java.util.function.*;

public class PromptForPerson {
    Scanner scanner;

    public PromptForPerson(Scanner scanner) {
        this.scanner = scanner;
    }

    public Person readPerson() {
        Person person = new Person();
        person.setName(genericRead("person name", String::new, PersonChecker::checkName));

        System.out.println("fill data about coordinates");
        person.setCoordinates(new Coordinates());
        person.getCoordinates().setX(genericRead("x", Double::parseDouble, CoordinatesChecker::checkX));
        person.getCoordinates().setY(genericRead("y", Double::parseDouble, CoordinatesChecker::checkY));

        person.setHeight(genericRead("height", Integer::parseInt, PersonChecker::checkHeight));
        person.setWeight(genericRead("weight", Float::parseFloat, PersonChecker::checkWeight));
        person.setEyeColor(genericRead("eye color. options: " + (Arrays.toString(Color.values())), PromptForPerson::toEyeColor, (String) -> true));
        person.setNationality(genericRead("nationality. options: " + (Arrays.toString(Country.values())), PromptForPerson::toCountry, (String) -> true));

        System.out.println("fill data about location");
        person.setLocation(new Location());
        person.getLocation().setX(genericRead("x", Double::parseDouble, LocationChecker::checkX));

        System.out.println("Enter yes if you want to fill date about y coordinate of location");
        if (scanner.nextLine().equals("yes"))
            person.getLocation().setY(genericRead("y", Float::parseFloat, LocationChecker::checkY));
        person.getLocation().setZ(genericRead("z", Integer::parseInt, LocationChecker::checkZ));

        return person;
    }

    private <T> T genericRead(String message, Function<String, T> parser, Predicate<T> constraint) {
        System.out.println("Enter " + message);
        while (true) {
            String inputValue = scanner.nextLine();
            try {
                T parsed;
                if (Objects.equals(inputValue, "") || Objects.equals(inputValue, "null")) {
                    parsed = null;
                } else {
                    parsed = parser.apply(inputValue);
                }
                if (constraint.test(parsed)) {
                    return parsed;
                }
            } catch (NullPointerException | IllegalArgumentException ignored) {
                System.out.println("Incorrect value. Try again");
            }
        }
    }

    private static Color toEyeColor(String value) {
        return Enum.valueOf(Color.class, value);
    }

    private static Country toCountry(String value) {
        return Enum.valueOf(Country.class, value);
    }
}
