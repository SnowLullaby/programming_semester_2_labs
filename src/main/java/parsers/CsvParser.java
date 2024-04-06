package parsers;

import models.Person;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *  Class parsing file with open CSV
 *  @author Ekaterina Vavilina
 */
public class CsvParser {

    /**
     * Parse file with open CSV
     * @return List of Persons from file with collection
     */
    public static List<Person> parsing(InputStreamReader reader) {
        CsvToBeanBuilder<Person> readerForCsv = new CsvToBeanBuilder<Person>(reader);
        return readerForCsv.withThrowExceptions(false).withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',').withType(Person.class).build().parse();
    }
}
