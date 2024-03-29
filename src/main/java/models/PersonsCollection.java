package models;

import exceptions.NoElementWithIDException;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import static checkers.PersonChecker.checkPerson;

public class PersonsCollection {
    private static final PersonsCollection instance = new PersonsCollection();
    private SaveLoader saveLoad;
    private ZonedDateTime creationTime;
    private LinkedHashMap<Long, Person> collection;
    @Getter @Setter
    private Long maxID = 0L;

    public static PersonsCollection getInstance() {
        if (instance.collection == null) throw new RuntimeException("Collection not initialized");
        return instance;
    }

    public static void initInstance(SaveLoader saveLoad) {
        fillingInstance(saveLoad);
    }

    private static void fillingInstance(SaveLoader saveLoad) {
        instance.saveLoad = saveLoad;
        var unchecked = instance.saveLoad.parse();
        instance.collection = new LinkedHashMap<>();
        for(Person person: unchecked) {
           if (checkPerson(person)) {
               instance.collection.put(person.getId(), person);
               if(instance.maxID < person.getId())
                   instance.maxID = person.getId();
           }
        }

        instance.defaultSortByID();
        instance.setCreationTimeAsNow();
    }

    public void defaultSortByID() {
        LinkedHashMap<Long, Person> sortedMap = instance.collection.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        instance.collection.clear();
        instance.collection.putAll(sortedMap);
    }

    public void descendingSortByID() {
        LinkedHashMap<Long, Person> sortedMap = instance.collection.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(new ItemLocationComparatorDescending())) // Сортировка записей по значению с использованием компаратора для сравнения в обратном порядке
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Заменяем существующую коллекцию на отсортированную
        instance.collection.clear();
        instance.collection.putAll(sortedMap);
    }

    public String getCreationTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss X");
        return formatter.format(instance.creationTime);
    }

    public void setCreationTimeAsNow() {
        instance.creationTime = ZonedDateTime.now();
    }

    public int getSize() {
        return instance.collection.size();
    }

    public void removeAll() {
        instance.collection.clear();
        findRealMaxID();
    }

    public void removeAt(Long index) throws NoElementWithIDException {
        if(instance.collection.get(index) == null)
            throw new NoElementWithIDException();
        instance.collection.remove(index);
        findRealMaxID();
    }

    public void removeGrater(Long index) {
        instance.collection.entrySet().removeIf(entry -> entry.getKey() > index);
        findRealMaxID();
    }

    public void save() throws FileNotFoundException {
        saveLoad.save(instance.collection);
    }

    public void removeByNationality(Country nationality) {
        instance.collection.entrySet().removeIf(entry -> entry.getValue().getNationality() == nationality);
        findRealMaxID();
    }

    public void addElement(Person person) {
        instance.collection.put(person.getId(),person);
        findRealMaxID();
    }

    private void findRealMaxID() {
        Long maxKey = 0L;
        for (Map.Entry<Long, Person> entry : instance.collection.entrySet()) {
            if (entry.getKey() > maxKey) {
                maxKey = entry.getKey();
            }
        }
        instance.maxID = maxKey;
    }

    public boolean getElementByID(Long index) {
        return instance.collection.get(index) != null;
    }

    public String getPersonByID(Long index) {
        return instance.collection.get(index).getName();
    }

    static class ItemLocationComparatorDescending implements Comparator<Long> {
        @Override
        public int compare(Long id1, Long id2) {
            return id2.compareTo(id1);
        }
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
