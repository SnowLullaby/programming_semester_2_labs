package parsers;

import com.opencsv.CSVWriter;
import models.Person;
import models.SaveLoader;
import java.io.*;
import java.util.*;

/**
 *  Class for saving and loading from file
 *  @author Ekaterina Vavilina
 */
public class SaveLoaderCSV implements SaveLoader {
    /** path to file */
    private final String fileName;

    /**
     * Set path to file
     * @param fileName path to file
     */
    public SaveLoaderCSV(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Parse file with collection
     * @return List of Persons from file with collection
     * @throws IOException reading lines from file exception
     */
    public List<Person> parse() throws IOException {
        var file = new File(fileName);
        InputStreamReader reader = new InputStreamReader(getFileStream(file));
        var result = CsvParser.parsing(reader);
        closeFile(reader);
        return result;
    }

    /**
     * Get file stream
     * @param file file with data
     * @return InputStreamReader
     * @throws FileNotFoundException no such file exception
     */
    private InputStream getFileStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
        // System.out.println("File doesn't exist or access is denied");
    }

    /**
     * Close reader
     * @param reader file with data
     * @throws IOException closing file exception
     */
    private void closeFile(InputStreamReader reader) throws IOException {
        reader.close();
        //System.out.println("Access to file is denied");
    }

    /**
     * Save collection to file
     * @param collection LinkedHashMap with all elements from collection
     * @throws FileNotFoundException open file exception
     */
    public void save(LinkedHashMap<Long, Person> collection) throws FileNotFoundException {
        var file = new File(fileName);
        var writer = new PrintWriter(file);
        CSVWriter csvWriter = new CSVWriter(writer);

        for (Long key : collection.keySet()) {
            Person value = collection.get(key);
            String[] str = value.getStrings();
            System.out.println(Arrays.toString(str));
            csvWriter.writeNext(str);
        }

        writer.close();
    }
}
