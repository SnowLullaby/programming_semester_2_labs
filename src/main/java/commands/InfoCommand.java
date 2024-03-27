package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import models.PersonsCollection;

public class InfoCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage) {
        String creationTime = PersonsCollection.getInstance().getCreationTime();
        int size = PersonsCollection.getInstance().getSize();
        return new ExecutionResult(String.format("Creation time: %s\nSize: %s\n", creationTime, size), true);
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "display information about collection (tip, creation date and etc.)", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("info", true);
    }
}
