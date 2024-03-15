package models;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class PersonsCollection {
    private static final PersonsCollection instance = new PersonsCollection();
    private final ZonedDateTime creationTime = ZonedDateTime.now();
    private SaveLoader saveLoad;
    private LinkedHashMap<Long, Person> collection;
    private Long maxID;

    public static PersonsCollection getInstance() {
        if (instance.collection == null) throw new RuntimeException("Collection not initialized");
        return instance;
    }

    public static void initInstance(SaveLoader saveLoad) {
        fillingInstance(saveLoad);
    }

    private static void fillingInstance(SaveLoader saveLoad) {
        instance.saveLoad = saveLoad;
        var collAndID = instance.saveLoad.parse();
        instance.maxID = collAndID.getKey();
        instance.collection = collAndID.getValue();
        instance.defaultSortByID();
    }

    public void defaultSortByID() {
        LinkedHashMap<Long, Person> sortedMap = collection.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        collection.clear();
        collection.putAll(sortedMap);
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Long, Person> entry : collection.entrySet()) {
            str.append(entry.getValue().toString()).append("\n");
        }
        return str.toString();
    }
}
