package parsers;

import com.opencsv.CSVWriter;
import models.Person;
import models.SaveLoader;
import java.io.*;
import java.util.*;

public class SaveLoaderCSV implements SaveLoader {
    /**path to file*/
    private final String fileName;
    /**pair of collection and maxID of the elements*/


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
    public void save(LinkedHashMap<Long, Person> collection) throws FileNotFoundException {
        var file = new File(fileName);
        var writer = new PrintWriter(file);
        CSVWriter csvWriter = new CSVWriter(writer);

        for (Long key : collection.keySet()) {
            Person value = collection.get(key);
            csvWriter.writeNext(value.getStrings());
        }

        writer.close();
    }
}
