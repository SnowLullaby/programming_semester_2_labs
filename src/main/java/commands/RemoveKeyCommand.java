package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import errors.NoElementWithID;
import errors.NoParamsError;
import models.PersonsCollection;

public class RemoveKeyCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage)  {
        try {
            if (requestMessage.commandInfo().args() == null)
                throw new NoParamsError();
            PersonsCollection.getInstance().removeAt(Long.valueOf(requestMessage.commandInfo().args().get(0)));
            return new ExecutionResult("Removed", true);
        } catch (NoElementWithID | NumberFormatException | NoParamsError e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("display all elements from collection in descending order", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("remove_key", true);
    }
}
