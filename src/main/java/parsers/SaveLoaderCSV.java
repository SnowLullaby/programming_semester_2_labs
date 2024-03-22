package parsers;

import models.Person;
import models.SaveLoader;
import java.io.*;
import java.util.*;

public class SaveLoaderCSV implements SaveLoader {
    /**path to file*/
    private final String fileName;
    /**pair of collection and maxID of the elements*/
    private LinkedHashMap<Long, Person> collection;

    /**
     * set path to file
     * @param fileName path to file
     */
    public SaveLoaderCSV(String fileName) {
        this.fileName = fileName;
    }
    public List<Person> parse() {
        var file = new File(fileName);
        InputStreamReader reader = new InputStreamReader(getFileStream(file));
        var result = CsvParser.parsing(reader);
        closeFile(reader);
        return result;
    }

    private InputStream getFileStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist or access is denied");
            System.exit(0);
        }
        return null;
    }

    private void closeFile(InputStreamReader reader){
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Access to file is denied");
        }
    }

    @Override
    public void save(LinkedHashMap<Long, Person> collectionAndID) {
        /*try {
            this.collectionAndID = collectionAndID;
            saveImp();
        } catch (PropertyException e) {
            System.out.println("Access to file is denied");
        } catch (JAXBException e) {
            System.out.println("Saving into file error. Error's text:");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Impossible open file for writing");
        }*/
    }
}
