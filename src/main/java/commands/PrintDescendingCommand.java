package commands;

import commandService.ExecutionResult;
import models.PersonsCollection;

public class PrintDescendingCommand extends ShowCommand{
    @Override
    public void sorting(){
        PersonsCollection.getInstance().descendingSortByID();
    }


    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("display all elements from collection in descending order", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("print_descending", true);
    }
}
