package models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Class for keeping Location of <b>Person</b>
 *  @author Ekaterina Vavilina
 *  @see Person#setLocation(Location)
 */
@Getter @Setter
public class Location {
    /** x coordinate */
    @CsvBindByPosition(position = 9, required = true)
    private Double x; //not null

    /** y coordinate */
    @CsvBindByPosition(position = 10)
    private float y;

    /** z coordinate */
    @CsvBindByPosition(position = 11, required = true)
    private Integer z; //not null

    /**
     * Function to return location as string
     * @return String
     */
    @Override
    public String toString(){
        return ("[" + x + "; " + y + "; " + z + "]");
    }

    /**
     * Function to return Location as String[] for CSV writer
     * @return String[]
     */
    public String[] getStrings() {
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(Double.toString(x), Float.toString(y), Integer.toString(z)));
        return parameters.toArray(new String[0]);
    }
}
