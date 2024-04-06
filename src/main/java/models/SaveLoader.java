package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *  Class for saving and loading from file
 *  @author Ekaterina Vavilina
 */
public interface SaveLoader {
    /**
     * Parse script file line by line
     * @return List of Persons from file with collection
     * @throws IOException - reading lines exception
     */
    public List<Person> parse() throws IOException;

    /**
     * Save collection to file
     * @param collection LinkedHashMap with all elements from collection
     * @throws FileNotFoundException open file exception
     */
    public void save(LinkedHashMap<Long, Person> collection) throws FileNotFoundException;
}
