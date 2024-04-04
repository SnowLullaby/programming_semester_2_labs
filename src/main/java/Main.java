import commandService.CommandService;
import parsers.SaveLoaderCSV;
import models.*;

import java.io.IOException;

/**
 *  Main class initialise collection of <b>Person</b> and service for <b>Commands</b>
 *  @see PersonsCollection
 *  @see CommandService
 *  @author Ekaterina Vavilina
 *  @version 1.0
 */
public class Main {
    /** Path to csv file with collection */
    private static String fileName;

    /**
     * Function create instance of <b>Person Collection</b>
     */
    public static void main(String[] args) {
        initFileName(System.getenv("lab")); //sysdm.cpl
        SaveLoader saveLoad = new SaveLoaderCSV(fileName);
        try {
            PersonsCollection.initInstance(saveLoad);
        } catch (IOException e){
            System.out.println("Problems with Collection initialization.\nError text: " + e.getMessage()+ "\nCause of error: " + e.getCause());
            System.exit(0);
        }

        CommandService.initInstance();
        var commandService = CommandService.getInstance();

        while (true) {
            commandService.execute();
        }
    }

    /**
     * Function get path to file as string from environment
     * @param fileName - string with path to fie
     */
    private static void initFileName (String fileName){
        try {
            Main.fileName = fileName;
        } catch (Exception e){
            System.out.println("File name not specified");
            System.exit(0);
        }
    }
}
