package com.example.refactoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void textStatementForRegularAndChildrensMovies() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(new Movie("Regular 1 Day", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Children 4 Days", Movie.CHILDRENS), 4));

        String result = customer.textStatement();

        String expected = "Rental Record for John Doe\n" +
                "\tRegular 1 Day\t0.5\n" +
                "\tChildren 4 Days\t1.5\n" +
                "Amount owed is 2.0\n";

        assertEquals(expected, result);
    }
}
