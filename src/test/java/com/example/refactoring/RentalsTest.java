package com.example.refactoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalsTest {

    @Test
    public void totalChargeWithNoRentals() {
        Rentals rentals = new Rentals();
        assertEquals(0.0, rentals.totalCharge());
    }

    @Test
    public void totalChargeWithSingleRental() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Regular", Movie.REGULAR), 1));
        assertEquals(0.5, rentals.totalCharge());
    }

    @Test
    public void totalChargeWithMultipleRentals() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Regular", Movie.REGULAR), 1));
        rentals.add(new Rental(new Movie("Children", Movie.CHILDRENS), 4));
        assertEquals(2.0, rentals.totalCharge());
    }
}
