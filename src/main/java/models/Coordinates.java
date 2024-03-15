package models;

/**
 * Store x and y Coordinates of Person from PersonsCollection
 */
public class Coordinates {
    private Double x; // not null
    private Double y; //not null <= 933

    // Setter for x coordinate
    public void setX(Double x) {
        this.x = x;
    }

    // Getter for x coordinate
    public Double getX() {
        return x;
    }

    // Setter for y coordinate
    public void setY(Double y) {
        this.y = y;
    }

    // Getter for y coordinate
    public Double getY() {
        return y;
    }

    @Override
    public String toString(){
        return ("[" + x + "; " + y + "]");
    }
}
