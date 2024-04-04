package commands;

import commandService.ExecutionResult;
import models.Person;
import models.PersonsCollection;

public class InsertCommand extends AddCommand{

    @Override
    public boolean conditionForPeron(Person person, Long id) {
        return true;
    }

    @Override
    protected boolean addCondition(Long id, String commandName) {
        return PersonsCollection.getInstance().getMaxID() < Integer.MAX_VALUE;
    }

    protected Long calculateId(Long id) {
        return PersonsCollection.getInstance().getMaxID() + 1;
    }

    public ExecutionResult showDescription() {
        return new ExecutionResult( "insert new person",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("insert",true);
    }
}
