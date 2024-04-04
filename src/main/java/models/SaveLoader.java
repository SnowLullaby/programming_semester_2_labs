package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface SaveLoader {
    public List<Person> parse() throws IOException;
    public void save(LinkedHashMap<Long, Person> collection) throws FileNotFoundException;
}
