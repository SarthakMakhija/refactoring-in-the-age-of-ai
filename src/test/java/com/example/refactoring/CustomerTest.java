package com.example.refactoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void statementForRegularMovieRentedForLessThanTwoDays() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Regular 1 Day", Movie.REGULAR), 1));

        String result = customer.statement();

        String expected = "Rental Record for John Doe\n" +
                "\tRegular 1 Day\t0.5\n" +
                "Amount owed is 0.5\n";

        assertEquals(expected, result);
    }

    @Test
    public void statementForRegularMovieRentedForMoreThanTwoDays() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Regular 3 Days", Movie.REGULAR), 3));

        String result = customer.statement();

        String expected = "Rental Record for John Doe\n" +
                "\tRegular 3 Days\t2.0\n" +
                "Amount owed is 2.0\n";

        assertEquals(expected, result);
    }

    @Test
    public void statementForChildrensMovieRentedForLessThanThreeDays() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Children 1 Day", Movie.CHILDRENS), 1));

        String result = customer.statement();

        String expected = "Rental Record for John Doe\n" +
                "\tChildren 1 Day\t-1.5\n" +
                "Amount owed is -1.5\n";

        assertEquals(expected, result);
    }

    @Test
    public void statementForChildrensMovieRentedForMoreThanThreeDays() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Children 4 Days", Movie.CHILDRENS), 4));

        String result = customer.statement();

        String expected = "Rental Record for John Doe\n" +
                "\tChildren 4 Days\t1.5\n" +
                "Amount owed is 1.5\n";

        assertEquals(expected, result);
    }

    @Test
    public void statementForRegularAndChildrensMovies() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Regular 1 Day", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Children 4 Days", Movie.CHILDRENS), 4));

        String result = customer.statement();

        String expected = "Rental Record for John Doe\n" +
                "\tRegular 1 Day\t0.5\n" +
                "\tChildren 4 Days\t1.5\n" +
                "Amount owed is 2.0\n";

        assertEquals(expected, result);
    }
}
