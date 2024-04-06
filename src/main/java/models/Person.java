package models;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvRecurse;
import lombok.*;

/**
 *  Class for keeping information about person
 *  @author Ekaterina Vavilina
 *  @see Coordinates
 *  @see Location
 *  @see Color
 *  @see Country
 */
@Setter
public class Person {
    /** unique id of person */
    @CsvBindByPosition(position = 0, required = true)
    @Getter
    private long id; // > 0 unique auto-generated

    /** name of person */
    @CsvBindByPosition(position = 1, required = true)
    @Getter
    private String name; //not null not ''

    /** coordinates of person */
    @CsvRecurse
    @Getter
    private Coordinates coordinates; //not null

    /** creation date of record inf about person */
    @CsvCustomBindByPosition(position = 4, required = true,  converter = ZoneDateTimeConverter.class)
    private ZonedDateTime creationDate; //not null auto-generated

    /** height of person */
    @CsvBindByPosition(position = 5, required = true)
    @Getter
    private Integer height; //not null >0

    /** weight of person */
    @CsvBindByPosition(position = 6, required = true)
    @Getter
    private Float weight; //not null >0

    /** eye color of person */
    @CsvBindByPosition(position = 7, required = true)
    @Getter
    private Color eyeColor; //not null

    /** nationality of person */
    @CsvBindByPosition(position = 8, required = true)
    @Getter
    private Country nationality; //not null

    /** location of person */
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

    /**
     * Function to return Person as string
     * @return String
     */
    @Override
    public String toString(){
        return ("[" + id + "; " + name + "; " + coordinates  + "; " + getCreationDate() + "; " +
                height + "; " + weight + "; " + eyeColor + " " + nationality + " " + location + "]");
    }

    /**
     * Function to return Person as String[] for CSV writer
     * @return String[]
     */
    public String[] getStrings() {
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(Long.toString(id), name));
        parameters.addAll(Arrays.asList(coordinates.getStrings()));
        parameters.addAll(Arrays.asList(getCreationDate(), Integer.toString(height), Float.toString(weight), eyeColor.toString(), nationality.toString()));
        parameters.addAll(Arrays.asList(location.getStrings()));
        return parameters.toArray(new String[0]);
    }
}
