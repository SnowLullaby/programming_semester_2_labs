package commands;

import commandService.*;
import parsers.ScriptParser;

public class ExecuteScriptCommand implements Command{
    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        try {
            var commands = ScriptParser.parse(requestMessage.commandInfo().args().get(0));
            for (String command: commands) {
                CommandService.getInstance().executeFromLine(new RequestMessage(new CommandInfo(command, null, null)));
            }
            return new ExecutionResult("Script's execution finished", true);
        } catch (Exception e) {
            return new ExecutionResult("Access to file denied", false);
        }
    }

    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult( "execute script from file. Script contain commands, same as in interactive mode",true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("execute_script",true);
    }

}
