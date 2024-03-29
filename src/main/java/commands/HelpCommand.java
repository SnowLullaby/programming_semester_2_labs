package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;

public class HelpCommand implements Command{
    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        var map = AllCommandsList.getAllCommands();
        StringBuilder result = new StringBuilder();
        for (String key : map.keySet()) {
            result.append(key).append(": ").append(map.get(key).showDescription().message()).append("\n");
        }
        return new ExecutionResult(result.toString(), true);
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "display commands info",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("help",true);
    }
}
