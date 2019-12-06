package CityBike;

public class User {
    private int userID;
    private static int nextUserID = 0;
    private String name;
    private String surname;
    private Bike currentlyRentedBike;
    private User user;

    public User(String name, String surname, Bike currentlyRentedBike) {
        this.userID = nextUserID;
        nextUserID++;
        this.name = name;
        this.surname = surname;
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public int getUserID() {
        return userID;
    }
    public String getName() {
        return name+" "+surname;
    }
    public Bike getCurrentlyRentedBike() {
        return currentlyRentedBike;
    }
    /* SETTER */
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setCurrentlyRentedBike(Bike currentlyRentedBike) {
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public String toString(User user) {
        this.user = user;
        if (user.getCurrentlyRentedBike()==null){
            return "User{" +
                    "userID=" + userID +
                    ", name='" + getName() + "'" +
                    ", no bike currently rented " +
                    '}';
        } else {
            return "User{" +
                    "userID=" + userID +
                    ", name='" + getName() + "'" +
                    ", currentlyRentedBike=" + currentlyRentedBike.getBikeID() +
                    ", color='"+currentlyRentedBike.getColor()+ "'" +
                    '}';
        }
    }
}
