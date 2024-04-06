package models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Class for keeping Coordinates of <b>Person</b>
 *  @author Ekaterina Vavilina
 *  @see Person#setCoordinates(Coordinates)
 */
@Getter @Setter
public class Coordinates {
    /** x coordinate */
    @CsvBindByPosition(position = 2, required = true)
    private Double x; // not null

    /** y coordinate */
    @CsvBindByPosition(position = 3, required = true)
    private Double y; //not null <= 933

    /**
     * Function to return coordinates as string
     * @return String
     */
    @Override
    public String toString(){
        return ("[" + x + "; " + y + "]");
    }

    /**
     * Function to return Coordinates as String[] for CSV writer
     * @return String[]
     */
    public String[] getStrings() {
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(Double.toString(x), Double.toString(y)));
        return parameters.toArray(new String[0]);
    }
}
