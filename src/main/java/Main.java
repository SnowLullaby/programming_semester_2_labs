import commandService.CommandService;
import parsers.SaveLoaderCSV;
import models.*;
public class Main {
    private static String fileName;

    /**
     * Initialize collection and call reader command
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

    private static void initFileName (String fileName){
        try {
            Main.fileName = fileName;
        } catch (Exception e){
            System.out.println("File name not specified");
            System.exit(0);
        }
    }

}
