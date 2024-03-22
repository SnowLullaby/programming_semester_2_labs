package parsers;

import models.Person;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.util.List;

public class CsvParser {
    public static List<Person> parsing(InputStreamReader reader) {
        try{
            CsvToBeanBuilder<Person> reader_for_csv = new CsvToBeanBuilder<Person>(reader);
            return reader_for_csv.withThrowExceptions(false).withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',').withType(Person.class).build().parse();
        } catch (Exception e) {
            System.out.println("Parsing CSV error. Error's text:");
            System.out.println(e.getMessage());
            System.out.println("Possible ways to correct: check file extension");
            System.exit(0);
        }
        return null;
    }
}
