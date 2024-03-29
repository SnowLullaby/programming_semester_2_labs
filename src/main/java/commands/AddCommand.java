package commands;


import commandService.*;
import exceptions.*;
import models.*;

abstract public class AddCommand implements Command{
    protected Person person = new Person();
    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        try{
            person = (Person) CommandService.getInstance().readPerson().commandInfo().extendedData();
            setIDAndDate(requestMessage.commandInfo().args() != null ? Long.valueOf(requestMessage.commandInfo().args().get(0))
                    : null);
            if (conditionForPeron(person, requestMessage.commandInfo().args() != null ? Long.valueOf(requestMessage.commandInfo().args().get(0))
                    : null)){
                PersonsCollection.getInstance().addElement(person);
                PersonsCollection.getInstance().setMaxID(calculateId(requestMessage.commandInfo().args() != null ? Long.valueOf(requestMessage.commandInfo().args().get(0))
                        : null));
                return new ExecutionResult("Element added", true);
            }
            return new ExecutionResult("New element is grater", true);
        } catch (NoMoreFreeIDException | NoElementWithIDException e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    public abstract boolean conditionForPeron(Person person, Long id);


    protected void setIDAndDate(Long id) throws NoMoreFreeIDException, NoElementWithIDException {
        if (addCondition(id)) {
            person.setId(calculateId(id));
            person.setCreationDateAsNow();
        } else throw new NoMoreFreeIDException();
    }

    protected abstract boolean addCondition(Long id) throws NoElementWithIDException;

    protected abstract Long calculateId(Long id);
    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "base add command realization",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("add",true);
    }
}
