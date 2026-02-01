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

    public String textStatement() {
        return new TextStatement(name, rentals).get();
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

    public double amount() {
        return movie.amount(daysRented);
    }

    public Figure figure() {
        return new Figure(movie.getTitle(), amount());
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

class TextStatement {
    private String name;
    private Rentals rentals;

    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String get() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            Figure figure = rental.figure();
            result += "\t" + figure.getMovieTitle() + "\t" +
                    String.valueOf(figure.getAmount()) + "\n";
        }
        return result;
    }

    private String footer() {
        return "Amount owed is " + String.valueOf(rentals.totalCharge()) + "\n";
    }
}

class Figure {
    private String movieTitle;
    private double amount;

    public Figure(String movieTitle, double amount) {
        this.movieTitle = movieTitle;
        this.amount = amount;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double getAmount() {
        return amount;
    }
}