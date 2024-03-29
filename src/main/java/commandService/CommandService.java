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
    private static final int MAX_SIZE = 7;
    private ArrayDeque<String> commandQueue = new ArrayDeque<>();

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
            addToDeque(getParam(0));
            ExecutionResult result = searchCommand(getParam(0)).execute(new RequestMessage(new CommandInfo(getParam(0), currentCommandLine.size() > 1 ? currentCommandLine.subList(1, currentCommandLine.size()) : null, null)));
            System.out.println(result.message());
        } catch (NoCommandError | NoParamsError e) {
            System.out.println(e.getMessage());
        }
    }

    private void addToDeque(String command) {
        if (instance.commandQueue.size() >= MAX_SIZE) {
            instance.commandQueue.removeFirst();
        }
        instance.commandQueue.addLast(command);
    }

    public RequestMessage getCommandDeque(){
        return new RequestMessage(new CommandInfo("history",null, commandQueue));
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

    public void executeFromLine(RequestMessage currentCommand) {
        currentCommandLine = Arrays.asList(currentCommand.commandInfo().name().trim().split(" "));
        try {
            ExecutionResult result = searchCommand(getParam(0)).execute(new RequestMessage(new CommandInfo(getParam(0), currentCommandLine.size() > 1 ? currentCommandLine.subList(1, currentCommandLine.size()) : null, null)));
            System.out.println(result.message());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect argument's tip");
        } catch (NoCommandError | NoParamsError e) {
            System.out.println(e.getMessage());
        }
    }
}