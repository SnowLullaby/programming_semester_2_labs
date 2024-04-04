package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import exceptions.*;
import models.PersonsCollection;

public class RemoveKeyCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage)  {
        try {
            if (requestMessage.commandInfo().args() == null)
                throw new NoParamsException(requestMessage.commandInfo().name());
            PersonsCollection.getInstance().removeAt(Long.valueOf(requestMessage.commandInfo().args().get(0)));
            return new ExecutionResult("Element with ID " + Long.valueOf(requestMessage.commandInfo().args().get(0)) + " removed", true);
        } catch (NoElementWithIDException | NoParamsException e) {
            return new ExecutionResult(e.getMessage(), false);
        } catch (NumberFormatException e){
            return new ExecutionResult("Incorrect argument's tip for command " + requestMessage.commandInfo().name(), true);
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
