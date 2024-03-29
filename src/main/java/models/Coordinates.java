package models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;

@Getter @Setter
public class Coordinates {
    @CsvBindByPosition(position = 2, required = true)
    private Double x; // not null

    @CsvBindByPosition(position = 3, required = true)
    private Double y; //not null <= 933

    @Override
    public String toString(){
        return ("[" + x + "; " + y + "]");
    }

    public String[] getStrings() {
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(Double.toString(x), Double.toString(y)));
        return parameters.toArray(new String[0]);
    }
}
