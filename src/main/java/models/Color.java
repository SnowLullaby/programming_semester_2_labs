package models;

public enum Color {
    RED ("Red"),
    BLUE ("Blue"),
    YELLOW("Yellow");
    private final String title;

    Color(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}