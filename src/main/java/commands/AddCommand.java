package commands;

import checkers.CoordinatesChecker;
import checkers.LocationChecker;
import checkers.PersonChecker;
import commandService.ExecutionResult;
import commandService.RequestMessage;
import errors.NoElementWithIDError;
import errors.NoMoreFreeIDError;
import models.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.*;

abstract public class AddCommand implements Command{
    protected Person person = new Person();
    private final Scanner sc = new Scanner(System.in);
    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        try{
            setIDAndDate(requestMessage.commandInfo().args() != null ? Long.valueOf(requestMessage.commandInfo().args().get(0))
                    : null);
            readAll();
            if (conditionForPeron(person, requestMessage.commandInfo().args() != null ? Long.valueOf(requestMessage.commandInfo().args().get(0))
                    : null)){
                PersonsCollection.getInstance().addElement(person);
                PersonsCollection.getInstance().setMaxID(calculateId(requestMessage.commandInfo().args() != null ? Long.valueOf(requestMessage.commandInfo().args().get(0))
                        : null));
                return new ExecutionResult("Element added", true);
            }
            return new ExecutionResult("New element is grater", true);
        } catch (NoMoreFreeIDError | NoElementWithIDError e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    public abstract boolean conditionForPeron(Person person, Long id);

    private void readAll() {
        person.setName(genericRead("person name", String::new, PersonChecker::checkName));

        System.out.println("fill data about coordinates");
        person.setCoordinates(new Coordinates());
        person.getCoordinates().setX(genericRead("x", Double::parseDouble, CoordinatesChecker::checkX));
        person.getCoordinates().setY(genericRead("y", Double::parseDouble, CoordinatesChecker::checkY));

        person.setHeight(genericRead("height", Integer::parseInt, PersonChecker::checkHeight));
        person.setWeight(genericRead("weight", Float::parseFloat, PersonChecker::checkWeight));
        person.setEyeColor(genericRead("eye color. options: " + (Arrays.toString(Color.values())), AddCommand::toEyeColor, (String) -> true));
        person.setNationality(genericRead("nationality. options: " + (Arrays.toString(Country.values())), AddCommand::toCountry, (String) -> true));

        System.out.println("fill data about location");
        person.setLocation(new Location());
        person.getLocation().setX(genericRead("x", Double::parseDouble, LocationChecker::checkX));

        System.out.println("Enter yes if you want to fill date about y coordinate of location");
        if (sc.nextLine().equals("yes"))
            person.getLocation().setY(genericRead("y", Float::parseFloat, LocationChecker::checkY));
        person.getLocation().setZ(genericRead("z", Integer::parseInt, LocationChecker::checkZ));
    }

    private <T> T genericRead(String message, Function<String, T> parser, Predicate<T> constraint) {
        System.out.println("Enter " + message);
        while (true) {
            String inputValue = sc.nextLine();
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

    protected void setIDAndDate(Long id) throws NoMoreFreeIDError, NoElementWithIDError {
        if (addCondition(id)) {
            person = new Person();
            person.setId(calculateId(id));
            person.setCreationDateAsNow();
        } else throw new NoMoreFreeIDError();
    }

    private static Color toEyeColor(String value) {
        return Enum.valueOf(Color.class, value);
    }

    private static Country toCountry(String value) {
        return Enum.valueOf(Country.class, value);
    }

    protected abstract boolean addCondition(Long id) throws NoElementWithIDError;

    protected abstract Long calculateId(Long id);
    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "base add command realization",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("add",true);
    }
}
