package commands;

import commandService.*;
import models.PersonsCollection;

public class ClearCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage) {
        PersonsCollection.getInstance().removeAll();
        return new ExecutionResult("Collection clearing is finished", true);
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "clear collection", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult( "clear", true);
    }

}
