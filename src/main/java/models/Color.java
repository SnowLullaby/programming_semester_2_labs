package models;

import commandService.CommandService;
import lombok.Getter;

/**
 *  Enum for keeping eye color of <b>Person</b>
 *  @author Ekaterina Vavilina
 *  @see Person#setEyeColor(Color)
 */
@Getter
public enum Color {
    RED,
    BLUE,
    YELLOW;

    /**
     * Function to return enum as string
     * @return String
     */
    @Override
    public String toString(){
        return (name());
    }
}