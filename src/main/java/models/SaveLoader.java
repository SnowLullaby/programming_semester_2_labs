package models;

import java.util.*;

public interface SaveLoader {
    public List<Person> parse();
    public void save(LinkedHashMap<Long, Person> collection);
}
