package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import models.PersonsCollection;

import java.io.FileNotFoundException;

public class SaveCommand implements Command{
    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        try{
            PersonsCollection.getInstance().save();
            return new ExecutionResult("File saved", true);
        } catch (FileNotFoundException e){
            return new ExecutionResult(e.toString(), false);
        }
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("save collection into file", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("save", true);
    }
}
