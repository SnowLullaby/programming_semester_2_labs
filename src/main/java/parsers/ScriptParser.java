package parsers;

import commandService.RequestMessage;

import java.io.*;
import java.util.ArrayList;

/**
 *  Command script parser class. Read lines from script file and return as collection of names
 *  @see commands.ExecuteScriptCommand#execute(RequestMessage)  callind from
 *  @author Ekaterina Vavilina
 */
public class ScriptParser {

    /**
     * Parse script file line by line
     * @param fileName path to file
     * @return ArrayList of commands from script file
     * @throws IOException reading lines exception
     */
    public static ArrayList<String> parse(String fileName) throws IOException {
        var file = new File(fileName);
        var reader = new BufferedReader(getFileStream(file));
        System.out.println(fileName);
        ArrayList<String> commandsList = fillCommandList(reader);
        reader.close();
        return commandsList;
    }

    /**
     * Get file stream
     * @param file file with data
     * @return InputStreamReader
     * @throws FileNotFoundException no such file exception
     */
    private static InputStreamReader getFileStream(File file) throws FileNotFoundException {
            return new InputStreamReader(new FileInputStream(file));
    }

    /**
     * Collects all command from file into general structure
     * @param reader with script file
     * @return collection of commands from script file
     * @throws IOException reading lines exception
     */
    private static ArrayList<String> fillCommandList(BufferedReader reader) throws IOException {
        ArrayList<String> commandsList = new ArrayList<>();
        String commandLine;
        while((commandLine = reader.readLine()) != null) commandsList.add(commandLine);
        return commandsList;
    }
}
