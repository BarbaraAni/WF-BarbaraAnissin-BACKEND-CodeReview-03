package CityBike;

import java.util.HashSet;

public class Stations {
    private int stationID;
    private String location;
    private HashSet<Bike> bikes;

    public Stations(int stationID, String location, HashSet<Bike> bikes) {
        this.stationID = stationID;
        this.location = location;
        this.bikes = bikes;
    }

    public int getStationID() {
        return stationID;
    }
    public String getLocation() {
        return location;
    }
    public HashSet<Bike> getBike(){
        return bikes;
    }
    /// SETTERS ///
    public void setBikes(Stations station, Bike bike) {
        station.getBike().add(bike);
    }
    public void rmBikes(Bike bike) {
        this.bikes.remove(bike);
    }

    /// ADDBIKE ///
    public void addBike(Stations station, Bike bike){
        station.setBikes(station, bike);
    }

    @Override
    public String toString() {
        return "Stations{" +
                "stationID=" + stationID +
                ", location='" + location + '\'' +
                ", bikes=" + bikes +
                '}';
    }
}
