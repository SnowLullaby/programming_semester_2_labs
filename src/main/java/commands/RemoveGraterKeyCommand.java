package commands;

import commandService.*;
import exceptions.NoParamsException;
import models.PersonsCollection;

public class RemoveGraterKeyCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage)  {
        try {
            if (requestMessage.commandInfo().args() == null)
                throw new NoParamsException();
            PersonsCollection.getInstance().removeGrater(Long.valueOf(requestMessage.commandInfo().args().get(0)));
            return new ExecutionResult("Removed", true);
        } catch (NumberFormatException | NoParamsException e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    public ExecutionResult showDescription() {
        return new ExecutionResult("remove elements with grater id", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("remove_grater_key", true);
    }
}
