package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import exceptions.*;
import models.PersonsCollection;

public class RemoveKeyCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage)  {
        try {
            if (requestMessage.commandInfo().args() == null)
                throw new NoParamsException();
            PersonsCollection.getInstance().removeAt(Long.valueOf(requestMessage.commandInfo().args().get(0)));
            return new ExecutionResult("Removed", true);
        } catch (NoElementWithIDException | NumberFormatException | NoParamsException e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("remove element by id", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("remove_key", true);
    }
}
