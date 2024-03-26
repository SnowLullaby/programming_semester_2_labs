package commandService;

import commands.AllCommands;
import commands.Command;
import commands.CommandDescription;
import errors.NoCommandError;
import errors.NoParamsError;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandService {
    private static final CommandService instance = new CommandService();
    private LinkedHashMap<String, CommandDescription> commandCollection;
    private String[] currentCommandLine = null;
    static Scanner scanner = new Scanner(System.in);

    public static CommandService getInstance() {
        if(instance.commandCollection == null) throw new RuntimeException("Command service not initialized");
        return instance;
    }

    public static void initInstance() {
        fillingCommandCollection();
    }

    private static void fillingCommandCollection() {
        instance.commandCollection = AllCommands.getAllCommands();
    }

    public void execute() {
        currentCommandLine = scanner.nextLine().trim().split(" ");
        try {
            searchCommand(getParam(0)).execute();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect argument's tip");
        } catch (NoCommandError | NoParamsError | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    private Command searchCommand(String name) throws NoCommandError, NoParamsError, NumberFormatException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> commandClass = commandCollection.get(name).getCommandClass();
        // Получаем конструктор класса
        Constructor<?> constructor = commandClass.getDeclaredConstructor();

        // Разрешаем доступ к приватному конструктору (если таковой имеется)
        constructor.setAccessible(true);

        // Создаем новый экземпляр класса
        Object instance_for_command = constructor.newInstance();

        return (Command) instance_for_command;
    }

    private String getParam(int index) throws NoParamsError {
        try {
            return currentCommandLine[index];
        } catch (Exception e) {
            throw new NoParamsError();
        }
    }
}