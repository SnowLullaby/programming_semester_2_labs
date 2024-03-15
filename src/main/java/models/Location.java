package models;

public class Location {
    private Double x; //not null
    private float y;
    private Integer z; //not null

    // Getter for x coordinate
    public Double getX() {
        return x;
    }

    // Setter for x coordinate
    public void setX(Double x) {
        this.x = x;
    }

    // Getter for y coordinate
    public Float getY() {
        return y;
    }

    // Setter for y coordinate
    public void setY(Float y) {
        this.y = y;
    }

    // Getter for z coordinate
    public Integer getZ() {
        return z;
    }

    // Setter for z coordinate
    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    public String toString(){
        return ("[" + x + "; " + y + "; " + z + "]");
    }
}
