package models;

import lombok.Getter;

/**
 *  Enum for keeping nationality of <b>Person</b>
 *  @author Ekaterina Vavilina
 *  @see Person#setNationality(Country)
 */
@Getter
public enum Country {
    USA,
    VATICAN,
    ITALY,
    JAPAN,
    NORTH_KOREA;

    /**
     * Function to return enum as string
     * @return String
     */
    @Override
    public String toString(){
        return (name());
    }
}
