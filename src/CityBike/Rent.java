package CityBike;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rent {
    private Bike bike;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private User user;
    private Stations stationFrom;
    private Stations stationTo;
    private ArrayList<Object[]> rentHistory = new ArrayList<>();

    public Rent(User user) {
        this.user = user;
    }

    public LocalDate getDateOfRent() {
        return rentStart;
    }

    public void setDateOfRent() {
        this.rentStart = LocalDate.now();
    }

    public String toRent(Stations stationFrom){
        this.stationFrom = stationFrom;
        if (user.getCurrentlyRentedBike()==null) {
            if (stationFrom.getBike().isEmpty()){
                return "Sorry "+user.getName()+", we currently don't have any bikes left here ("+stationFrom.getLocation()+").";
            } else { //stationFrom.getBike().stream().findFirst().isPresent(); - opposite of isEmpty()
                this.bike = stationFrom.getBike().stream().findFirst().get();
                if (bike.getState().equals(Status.CanBeRented)) { //CHECK IF AVAILABLE
                    this.stationFrom.getBike().remove(bike);
                    bike.setState(Status.CanNotBeRented);
                    user.setCurrentlyRentedBike(bike);
                    this.setDateOfRent();
                    startRentHistory();
                    return "Bike " + bike.getBikeID() + " in color " + bike.getColor() + " successfully rented by " + user.getName() + "!";
                } else {
                    return "Bike " + bike.getBikeID() + " is currently not available! We are very Sorry " + user.getName() + ".";
                }
            }
        } else {
            return "Please bring back bike "+user.getCurrentlyRentedBike().getBikeID()+" before renting a different bike "+user.getName()+".";
        }
    }

    public String toBringBack(Stations stationTo){
        this.bike = user.getCurrentlyRentedBike();
        this.stationTo = stationTo;
        if (stationTo.getBike()==null || stationTo.getBike().size()<5){
            bike.setState(Status.CanBeRented);
            stationTo.addBike(stationTo, bike);
            user.setCurrentlyRentedBike(null);
            rentEnd = LocalDate.of(2019,12,13); //example end date
            endRentHistory();
            return "Bike "+bike.getBikeID()+" in color "+bike.getColor()+" has been brought back to Station "+stationTo.getStationID()+" on "+rentEnd+" by " + user.getName() + ".";
        } else {
            return "There is currently no free space in "+stationTo.getLocation()+"'s "+stationTo.getStationID()+".";
        }
    }

    public void startRentHistory(){
        Object[] tracking = {bike.getBikeID(), rentStart, null};
        rentHistory.add(tracking);
    }
    public void endRentHistory(){
        Object[] tracking = {bike.getBikeID(), rentStart, rentEnd};
        rentHistory.add(tracking);
    }

    public String showRentHistory(){
        if (rentHistory.isEmpty()){
            return user.getName() + " didn't rent a bike yet.";
        } else {
            String output = "";
             for (Object[] x: rentHistory) {
                 if (x[2]!=null){
                     output += "User: "+user.getName()+"\n Bike ID: "+x[0]+"\n Rent Start: "+x[1]+"\n Rent End: "+x[2]+"\n---------------\n";
                 } else {
                     output += "User: "+user.getName()+"\n Bike ID: "+x[0]+"\n Rent Start: "+x[1]+"\n Rent End: Bike is not returned yet \n---------------\n";
                 }
                 //chronologic output - if bike is returned, there will be two paragraphs for one bike id
             }
             return output;
        }
    }

    public String toString() {
        if (user.getCurrentlyRentedBike()==null) {
            return "Rent: " +
                    "userID = " + user.getUserID() +
                    ", username = " + user.getName() +
                    ", currently no bike ";
        } else {
            return "Rent: " +
                    "userID = " + user.getUserID() +
                    ", username = " + user.getName() +
                    ", bikeID = " + bike.getBikeID() +
                    ", from station = "+ stationFrom.getLocation() +
                    ", Start-date of rent: "+getDateOfRent();
        }
    }
}
