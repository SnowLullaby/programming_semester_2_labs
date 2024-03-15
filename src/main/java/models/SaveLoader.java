package models;

import java.util.*;

public interface SaveLoader {
    public AbstractMap.SimpleEntry<Long, LinkedHashMap<Long, Person>> parse();
    public void save(AbstractMap.SimpleEntry<Long, LinkedHashMap<Long, Person>> collectionAndID);
}
