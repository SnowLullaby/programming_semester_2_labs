package commands;

import commandService.ExecutionResult;
import exceptions.NoElementWithIDException;
import exceptions.NoParamsException;
import models.Person;
import models.PersonsCollection;

public class UpdateCommand extends AddCommand{
    @Override
    public boolean conditionForPeron(Person person, Long id) {
        return true;
    }

    @Override
    protected boolean addCondition(Long id, String commandName) throws NoElementWithIDException, NoParamsException {
        if(id != null) {
            if (PersonsCollection.getInstance().getElementByID(id))
                return PersonsCollection.getInstance().getElementByID(id);
            throw new NoElementWithIDException(id);
        }
        throw new NoParamsException(commandName);
    }

    @Override
    protected Long calculateId(Long id) {
        return id;
    }

    public ExecutionResult showDescription() {
        return new ExecutionResult( "update person by id",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("update",true);
    }
}
