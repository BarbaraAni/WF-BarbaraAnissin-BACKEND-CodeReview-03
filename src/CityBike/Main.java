package CityBike;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //CREATING BIKES
        Bike bike0 = new Bike("red", Status.CanBeRented);
        Bike bike1 = new Bike("yellow",Status.CanBeRented);
        Bike bike2 = new Bike("black",Status.CanBeRented);
        Bike bike3 = new Bike("grey",Status.CanBeRented);
        Bike bike4 = new Bike("green",Status.CanBeRented);
        Bike bike5 = new Bike("violet",Status.InService);
        Bike bike6 = new Bike("blue",Status.CanBeRented);
        Bike bike7 = new Bike("lime",Status.Discarded);
        Bike bike8 = new Bike("white",Status.CanBeRented);

        HashMap<Integer,Bike> bikes = new HashMap<>();
        bikes.put(bike0.getBikeID(),bike0);
        bikes.put(bike1.getBikeID(),bike1);
        bikes.put(bike2.getBikeID(),bike2);
        bikes.put(bike3.getBikeID(),bike3);
        bikes.put(bike4.getBikeID(),bike4);
        bikes.put(bike5.getBikeID(),bike5);
        bikes.put(bike6.getBikeID(),bike6);
        bikes.put(bike7.getBikeID(),bike7);
        bikes.put(bike8.getBikeID(),bike8);

        //SETTING UP STATIONS
        HashSet<Bike> bikes1 = new HashSet<>();
        HashSet<Bike> bikes2 = new HashSet<>();
        HashSet<Bike> bikes3 = new HashSet<>();
        Stations station0 = new Stations(0,"Vienna - 1. Bezirk", bikes1);
        Stations station1 = new Stations(1, "Vienna - 2. Bezirk",bikes2);
        Stations station2 = new Stations(2,"Vienna - 3. Bezirk",bikes3);

        HashMap<Integer,Stations> stations = new HashMap<>();
        stations.put(station0.getStationID(),station0);
        stations.put(station1.getStationID(),station1);
        stations.put(station2.getStationID(),station2);

        //CREATING USERS
        User user0 = new User("Mona", "Lisa",null);
        User user1 = new User("Denny","DeVito",null);
        User user2 = new User("Luisa","Example",null);
        User user3 = new User("Troy","Franky",null);

        HashMap<Integer, User> users = new HashMap<>();
        users.put(user0.getUserID(),user0);
        users.put(user1.getUserID(),user1);
        users.put(user2.getUserID(),user2);
        users.put(user3.getUserID(),user3);

        //INITIALIZING ABILITY OF USERS TO RENT
        Rent rent0 = new Rent(user0);
        Rent rent1 = new Rent(user1);
        Rent rent2 = new Rent(user2);
        Rent rent3 = new Rent(user3);

        HashMap<Integer,Rent> rents = new HashMap<>();
        rents.put(user0.getUserID(),rent0);
        rents.put(user1.getUserID(),rent1);
        rents.put(user2.getUserID(),rent2);
        rents.put(user3.getUserID(),rent3);

        //FIRST TIME ADDING BIKES TO STATIONS
        station1.addBike(station1, bike0);
        station1.addBike(station1, bike1);
        station2.addBike(station2, bike2);
        station2.addBike(station2, bike3);
        station2.addBike(station2, bike4);
        station0.addBike(station0, bike6);
        station0.addBike(station0, bike8);

        /////// SETUP ENDS HERE ///////
        ///// EXAMPLES START HERE /////

        //RENT
        System.out.println("---- RENTING PROCESSES ----");
        System.out.println(rent0.toRent(station1));
        System.out.println(rent1.toRent(station0));
        System.out.println(rent2.toRent(station0));
        System.out.println(rent2.toBringBack(station2));
        System.out.println(rent2.toRent(station2));
        System.out.println(rent2.toRent(station2)); //user 2 comes back for a second bike

        //change over time - bike 1 has been repainted and bike 5 is back from service
        bike1.setColor("green");
        bike5.setState(Status.CanBeRented);
        station2.addBike(station2, bike5);

        //RENT
        System.out.println(rent0.toBringBack(station1));
        System.out.println(rent0.toRent(station0));
        System.out.println(rent0.toRent(station2));
        System.out.println(rent1.toBringBack(station0));

        //change over time - bike 0 was discarded
        bike0.setState(Status.Discarded);
        station1.rmBikes(bike0);

        System.out.println("===================");
        System.out.println("= AVAILABLE BIKES =");
        bikes.forEach((k,v) -> {
            if (v.getState()==Status.CanBeRented)
                System.out.println(v);
        });
        System.out.println("===================");
        System.out.println("= ALL DATA LISTED =");
        ////////// ALL DATA LISTED //////////
        System.out.println("----- Bike Data:");
        bikes.forEach((k,v) -> {
            System.out.println(v.toString());
        });
        System.out.println("----- Stations Data:");
        stations.forEach((k,v) -> {
            System.out.println(v.toString());
        });
        System.out.println("----- User Data:");
        users.forEach((k,v)-> {
            System.out.println(v.toString(v));
        });
        System.out.println("----- Current Rents Data:");
        rents.forEach((k,v)-> {
            System.out.println(v.toString());
        });

        System.out.println("----- Tracking:");
        System.out.print(rent0.showRentHistory());
        System.out.print(rent1.showRentHistory());
        System.out.print(rent2.showRentHistory());
        System.out.print(rent3.showRentHistory());
    }
}
