package models;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
    private long id; // >0 unique auto-generated
    private String name; //not null not ''
    private Coordinates coordinates; //not null
    private ZonedDateTime creationDate; //not null auto-generated
    private Integer height; //not null >0
    private Float weight; //not null >0
    private Color eyeColor; //not null
    private Country nationality; //not null
    private Location location; //not null

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set creation date from string, used in AddCommand, AddIfMinCommand and UpdateCommand
     * @param date - creation date as String
     */
    public void setCreationDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss z");
        creationDate = ZonedDateTime.parse(date, formatter);
    }

    /**
     * Convert creation date to string
     * @return creation date as String
     */
    public String getCreationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss z");
        return formatter.format(creationDate);
    }

    /**
     * Set current date as creation date, used in AddCommand, AddIfMinCommand and UpdateCommand
     * now() - current date
     */
    public void setCreationDateAsNow() {
        creationDate = ZonedDateTime.now();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public String toString(){
        return ("[" + id + "; " + name + "; " + coordinates  + "; " + getCreationDate() + "; " +
                height + "; " + weight + "; " + eyeColor + " " + nationality + " " + location + "]");
    }
}
