import commandService.CommandService;
import parsers.SaveLoaderCSV;
import models.*;

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
        PersonsCollection.initInstance(saveLoad);
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
