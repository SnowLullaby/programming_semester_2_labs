package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;

public interface Command {
    public ExecutionResult execute(RequestMessage requestMessage);
    public ExecutionResult showDescription();

    public static ExecutionResult getName() {
        return null;
    }

}
