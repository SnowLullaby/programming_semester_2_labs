package models;

import lombok.Getter;

@Getter
public enum Color {
    RED ("Red"),
    BLUE ("Blue"),
    YELLOW("Yellow");
    private final String title;

    Color(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return (title + "; ");
    }
}