package CityBike;

public class Bike {
    private int bikeID;
    private static int nextBikeID = 0;
    private String color;
    private Status state;

    public Bike(String color, Status state) {
        this.bikeID = nextBikeID;
        nextBikeID++;
        this.color = color;
        this.state = state;
    }

    public int getBikeID() {
        return bikeID;
    }
    public String getColor() {
        return color;
    }
    public Status getState() {
        return state;
    }

    /* SETTER */
    public void setColor(String color) {
        this.color = color;
    }
    public void setState(Status state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeID=" + bikeID +
                ", color='" + color + "'" +
                ", state='" + getState() + "'" +
                '}';
    }
}
