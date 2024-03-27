package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;

public class ExitCommand implements Command{
    public ExecutionResult execute(RequestMessage requestMessage) {
        System.out.println("See you later!");
        System.exit(0);
        return null;
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("exiting program (without saving)",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult( "exit", true);
    }
}
