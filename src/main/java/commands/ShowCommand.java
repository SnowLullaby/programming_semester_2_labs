package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import models.PersonsCollection;

public class ShowCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage) {
        String result = "There are " + PersonsCollection.getInstance().getSize() + " elements in collection\n";
        sorting();
        return new ExecutionResult(result + PersonsCollection.getInstance().toString(), true);
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "display all elements from collection in natural order", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("show", true);
    }

    public void sorting(){
        PersonsCollection.getInstance().defaultSortByID();
    }

}
