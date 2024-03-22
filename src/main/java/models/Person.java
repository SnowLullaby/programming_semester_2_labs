package models;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvRecurse;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import lombok.*;

@Setter
public class Person {
    @CsvBindByPosition(position = 0, required = true)
    @Getter
    private long id; // >0 unique auto-generated

    @CsvBindByPosition(position = 1, required = true)
    @Getter
    private String name; //not null not ''

    @CsvRecurse
    @Getter
    private Coordinates coordinates; //not null

    @CsvCustomBindByPosition(position = 4, required = true,  converter = ZoneDateTimeConverter.class)
    private ZonedDateTime creationDate; //not null auto-generated

    @CsvBindByPosition(position = 5, required = true)
    @Getter
    private Integer height; //not null >0

    @CsvBindByPosition(position = 6, required = true)
    @Getter
    private Float weight; //not null >0

    @CsvBindByPosition(position = 7, required = true)
    @Getter
    private Color eyeColor; //not null

    @CsvBindByPosition(position = 8, required = true)
    @Getter
    private Country nationality; //not null

    @CsvRecurse
    @Getter
    private Location location; //not null

    /**
     * Convert creation date to string
     * @return creation date as String
     */
    public String getCreationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss X");
        return formatter.format(creationDate);
    }

    /**
     * Set current date as creation date, used in AddCommand, AddIfMinCommand and UpdateCommand
     * now() - current date
     */
    public void setCreationDateAsNow() {
        creationDate = ZonedDateTime.now();
    }

    @Override
    public String toString(){
        return ("[" + id + "; " + name + "; " + coordinates  + "; " + getCreationDate() + "; " +
                height + "; " + weight + "; " + eyeColor + " " + nationality + " " + location + "]");
    }

}
