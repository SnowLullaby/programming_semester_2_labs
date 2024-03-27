package commands;

import commandService.ExecutionResult;
import models.PersonsCollection;

public class PrintAscendingCommand extends ShowCommand{

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "display all elements from collection in ascending order",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("print_ascending",true);
    }
}
