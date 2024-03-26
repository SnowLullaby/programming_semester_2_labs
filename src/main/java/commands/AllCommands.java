package commands;

import java.util.LinkedHashMap;

public class AllCommands {
    private static LinkedHashMap<String, CommandDescription> allCommands;
    public static LinkedHashMap<String, CommandDescription> getAllCommands() {
        fillingMap();
        return allCommands;
    }

    private static void fillingMap() {
        allCommands = new LinkedHashMap<String, CommandDescription> ();
        allCommands.put("info", new CommandDescription("info", "display information about collection (tip, creation date and etc.)", InfoCommand.class));
        allCommands.put("show", new CommandDescription("show", "display all elements from collection", ShowCommand.class));
        allCommands.put("clear", new CommandDescription("clear","clear collection", ClearCommand.class));
        allCommands.put("exit", new CommandDescription("exit","exiting program (without saving)", ExitCommand.class));
        allCommands.put("print_ascending", new CommandDescription("print_ascending", "display all elements from collection in ascending order", PrintAscendingCommand.class));
        allCommands.put("print_descending", new CommandDescription("print_descending", "display all elements from collection in descending order", PrintDescendingCommand.class));
    }
}
