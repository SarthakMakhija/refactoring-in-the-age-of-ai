package com.example.refactoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void amountForRegularMovieRentedForLessThanTwoDays() {
        Movie movie = new Movie("Regular", Movie.REGULAR);
        assertEquals(0.5, movie.amount(1));
    }

    @Test
    public void amountForRegularMovieRentedForTwoDaysOrMore() {
        Movie movie = new Movie("Regular", Movie.REGULAR);
        assertEquals(2.0, movie.amount(3));
    }

    @Test
    public void amountForChildrensMovieRentedForLessThanThreeDays() {
        Movie movie = new Movie("Childrens", Movie.CHILDRENS);
        assertEquals(-1.5, movie.amount(1));
    }

    @Test
    public void amountForChildrensMovieRentedForThreeDaysOrMore() {
        Movie movie = new Movie("Childrens", Movie.CHILDRENS);
        assertEquals(1.5, movie.amount(4));
    }
}
