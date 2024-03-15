package models;

public enum Country {
    USA ("USA"),
    VATICAN ("Vatican"),
    ITALY ("Italy"),
    NORTH_KOREA ("North Korea"),
    JAPAN ("Japan");

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
