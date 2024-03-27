package commandService;

import commands.AllCommandsList;
import commands.Command;
import errors.*;

import java.util.*;

public class CommandService {
    private static final CommandService instance = new CommandService();
    private LinkedHashMap<String, Command> commandCollection;
    private List<String> currentCommandLine = null;
    static Scanner scanner = new Scanner(System.in);

    public static CommandService getInstance() {
        if(instance.commandCollection == null) throw new RuntimeException("Command service not initialized");
        return instance;
    }

    public static void initInstance() {
        fillingCommandCollection();
    }

    private static void fillingCommandCollection() {
        instance.commandCollection = AllCommandsList.getAllCommands();
    }

    public void execute() {
        currentCommandLine = Arrays.asList(scanner.nextLine().trim().split(" "));
        try {
            ExecutionResult result = searchCommand(getParam(0)).execute(new RequestMessage(new CommandInfo(getParam(0), currentCommandLine.size() > 1 ? currentCommandLine.subList(1, currentCommandLine.size()) : null, null)));
            System.out.println(result.message());
        } catch (NoCommandError | NoParamsError e) {
            System.out.println(e.getMessage());
        }

    }

    private Command searchCommand(String name) throws NoCommandError, NoParamsError {
        if (!commandCollection.containsKey(name))
            throw new NoCommandError();
        return commandCollection.get(name);
    }

    private String getParam(int index) throws NoParamsError {
        try {
            return currentCommandLine.get(index);
        } catch (Exception e) {
            throw new NoParamsError();
        }
    }
}