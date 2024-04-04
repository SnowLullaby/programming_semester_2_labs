package parsers;

import models.Person;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.util.List;

public class CsvParser {
    public static List<Person> parsing(InputStreamReader reader) {
        CsvToBeanBuilder<Person> readerForCsv = new CsvToBeanBuilder<Person>(reader);
        return readerForCsv.withThrowExceptions(false).withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',').withType(Person.class).build().parse();
    }
}
