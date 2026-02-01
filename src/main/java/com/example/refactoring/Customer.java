package com.example.refactoring;

import java.util.ArrayList;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }
        return result;
    }

    private String footer() {
        return "Amount owed is " + String.valueOf(rentals.totalCharge()) + "\n";
    }
}

class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public double amount(int daysRented) {
        double amount = 0;
        switch (priceCode) {
            case REGULAR:
                amount += 2;
                if (daysRented < 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case CHILDRENS:
                amount += 1.5;
                if (daysRented < 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }
}

class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount() {
        return movie.amount(daysRented);
    }
}

class Rentals extends ArrayList<Rental> {
    public double totalCharge() {
        double result = 0;
        for (Rental rental : this) {
            result += rental.amount();
        }
        return result;
    }
}