package models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

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
}
