package models;

import lombok.Getter;

@Getter
public enum Country {
    USA,
    VATICAN,
    ITALY,
    JAPAN,
    NORTH_KOREA;

    @Override
    public String toString(){
        return (name() + "; ");
    }
}
