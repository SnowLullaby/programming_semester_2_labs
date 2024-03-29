package commands;

import java.util.LinkedHashMap;

public class AllCommandsList {
    private static LinkedHashMap<String, Command> allCommands;
    public static LinkedHashMap<String, Command> getAllCommands() {
        fillingMap();
        return allCommands;
    }

    private static void fillingMap() {
        allCommands = new LinkedHashMap<String, Command> ();
        allCommands.put(InfoCommand.getName().message(), new InfoCommand());
        allCommands.put(ShowCommand.getName().message(), new ShowCommand());
        allCommands.put(ClearCommand.getName().message(), new ClearCommand());
        allCommands.put(ExitCommand.getName().message(), new ExitCommand());
        allCommands.put(PrintAscendingCommand.getName().message(), new PrintAscendingCommand());
        allCommands.put(PrintDescendingCommand.getName().message(), new PrintDescendingCommand());
        allCommands.put(RemoveKeyCommand.getName().message(), new RemoveKeyCommand());
        allCommands.put(HelpCommand.getName().message(), new HelpCommand());
        allCommands.put(RemoveGraterKeyCommand.getName().message(), new RemoveGraterKeyCommand());
        allCommands.put(SaveCommand.getName().message(), new SaveCommand());
        allCommands.put(RemoveAllByNationalityCommand.getName().message(), new RemoveAllByNationalityCommand());
        allCommands.put(ExecuteScriptCommand.getName().message(), new ExecuteScriptCommand());
        allCommands.put(InsertCommand.getName().message(), new InsertCommand());
        allCommands.put(UpdateCommand.getName().message(), new UpdateCommand());
        allCommands.put(ReplaceIfLowerCommand.getName().message(), new ReplaceIfLowerCommand());
        allCommands.put(HistoryCommand.getName().message(), new HistoryCommand());
    }
}
