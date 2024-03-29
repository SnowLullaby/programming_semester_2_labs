package commands;

import commandService.ExecutionResult;
import models.Person;
import models.PersonsCollection;

public class ReplaceIfLowerCommand extends UpdateCommand {
    @Override
    public boolean conditionForPeron(Person person, Long id) {
        return person.getName().compareTo(PersonsCollection.getInstance().getPersonByID(id)) < 0;
    }

    public ExecutionResult showDescription() {
        return new ExecutionResult( "replace by id if person has lower name",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("replace_if_lower",true);
    }
}
