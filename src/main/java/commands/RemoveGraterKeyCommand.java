package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import errors.NoParamsError;
import models.PersonsCollection;

public class RemoveGraterKeyCommand extends RemoveKeyCommand{
    public ExecutionResult execute(RequestMessage requestMessage)  {
        try {
            if (requestMessage.commandInfo().args() == null)
                throw new NoParamsError();
            PersonsCollection.getInstance().removeGrater(Long.valueOf(requestMessage.commandInfo().args().get(0)));
            return new ExecutionResult("Removed", true);
        } catch (NumberFormatException | NoParamsError e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("remove elements with grater id", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("remove_grater_key", true);
    }
}
