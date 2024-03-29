package models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;

@Getter @Setter
public class Location {
    @CsvBindByPosition(position = 9, required = true)
    private Double x; //not null

    @CsvBindByPosition(position = 10)
    private float y;

    @CsvBindByPosition(position = 11, required = true)
    private Integer z; //not null

    @Override
    public String toString(){
        return ("[" + x + "; " + y + "; " + z + "]");
    }

    public String[] getStrings() {
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(Double.toString(x), Float.toString(y), Integer.toString(z)));
        return parameters.toArray(new String[0]);
    }
}
