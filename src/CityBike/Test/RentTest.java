package CityBike.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CityBike.*;

import java.util.Arrays;
import java.util.HashSet;

class RentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Test Rent
    HashSet<Bike> bikes2 = new HashSet<>;
    User user5 = new User("Som","Body", null;
    Stations station4 = new Stations(4,"Vienna",bikes2);
    Rent rent4 = new Rent(user5);
    Bike bike4 = new Bike("green", Status.CanBeRented);
    @Test
    void toRent() {
        assertEquals("Bike 4 in color green successfully rented by Som Body!",rent4.toRent(station4));
    }

    @Test
    void toBringBack() {
    }

    @Test
    void getDateOfRent() {
    }

    @Test
    void setDateOfRent() {
    }

    @Test
    void startRentHistory() {
    }

    @Test
    void endRentHistory() {
    }

    @Test
    void showRentHistory() {
    }

    @Test
    void testToString() {
    }
}