package model;

import Strategy_Pattern_for_Delivery.DeliveryStrategy;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int year;
    protected double price;
    protected String author;
    protected DeliveryStrategy deliveryStrategy;

    public Book(String isbn, String title, int year, double price, String author, DeliveryStrategy deliveryStrategy) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
        this.deliveryStrategy = deliveryStrategy;
    }

    public abstract boolean isForSale();
    public abstract boolean isAvailable();
    public abstract void deliver(String email, String address);

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
