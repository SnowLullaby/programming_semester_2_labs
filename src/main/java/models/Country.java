package models;

public enum Country {
    USA ("USA"),
    VATICAN ("Vatican"),
    ITALY ("Italy"),
    JAPAN ("Japan"),
    NORTH_KOREA("North_Korea");

    private final String title;

    Country(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
