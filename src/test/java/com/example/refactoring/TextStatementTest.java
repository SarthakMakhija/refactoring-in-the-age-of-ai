package com.example.refactoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextStatementTest {

    @Test
    public void regularMovieRentedForLessThanTwoDays() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Regular 1 Day", Movie.REGULAR), 1));
        TextStatement statement = new TextStatement("John Doe", rentals);

        String expected = "Rental Record for John Doe\n" +
                "\tRegular 1 Day\t0.5\n" +
                "Amount owed is 0.5\n";

        assertEquals(expected, statement.get());
    }

    @Test
    public void regularMovieRentedForTwoOrMoreDays() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Regular 3 Days", Movie.REGULAR), 3));
        TextStatement statement = new TextStatement("John Doe", rentals);

        String expected = "Rental Record for John Doe\n" +
                "\tRegular 3 Days\t2.0\n" +
                "Amount owed is 2.0\n";

        assertEquals(expected, statement.get());
    }

    @Test
    public void childrensMovieRentedForLessThanThreeDays() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Children 1 Day", Movie.CHILDRENS), 1));
        TextStatement statement = new TextStatement("John Doe", rentals);

        String expected = "Rental Record for John Doe\n" +
                "\tChildren 1 Day\t-1.5\n" +
                "Amount owed is -1.5\n";

        assertEquals(expected, statement.get());
    }

    @Test
    public void childrensMovieRentedForThreeOrMoreDays() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Children 4 Days", Movie.CHILDRENS), 4));
        TextStatement statement = new TextStatement("John Doe", rentals);

        String expected = "Rental Record for John Doe\n" +
                "\tChildren 4 Days\t1.5\n" +
                "Amount owed is 1.5\n";

        assertEquals(expected, statement.get());
    }
}
