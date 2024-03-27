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
    }
}
