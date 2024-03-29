package parsers;

import java.io.*;
import java.util.ArrayList;

public class ScriptParser {
    /**
     * parse script file
     * @param fileName - path to file
     * @return collection of commands from script file
     * @throws Exception
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
     * get file stream
     * @param file with data
     * @return InputStreamReader
     */
    private static InputStreamReader getFileStream(File file) throws FileNotFoundException {
            return new InputStreamReader(new FileInputStream(file));
    }

    /**
     * Collects all command from file into general structure
     *
     * @param reader with script file
     * @return collection of commands from script file
     * @throws IOException - errors from reading lines
     */
    private static ArrayList<String> fillCommandList(BufferedReader reader) throws IOException {
        ArrayList<String> commandsList = new ArrayList<>();
        String commandLine;
        while((commandLine = reader.readLine()) != null) commandsList.add(commandLine);
        return commandsList;
    }
}
