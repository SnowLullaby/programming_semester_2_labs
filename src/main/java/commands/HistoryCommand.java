package commands;

import commandService.*;

public class HistoryCommand implements Command{

    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        return new ExecutionResult(CommandService.getInstance().getCommandDeque().commandInfo().extendedData().toString(), true);
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "display last 7 commands",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("history",true);
    }
}
