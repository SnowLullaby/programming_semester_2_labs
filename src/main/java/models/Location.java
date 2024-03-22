package models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

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
}
