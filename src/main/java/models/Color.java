package models;

import lombok.Getter;

@Getter
public enum Color {
    RED,
    BLUE,
    YELLOW;

    @Override
    public String toString(){
        return (name() + "; ");
    }
}