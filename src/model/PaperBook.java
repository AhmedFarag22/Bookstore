package model;

import Strategy_Pattern_for_Delivery.ShippingDeliveryStrategy;

public class PaperBook extends Book{

    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author, new ShippingDeliveryStrategy());

        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock(int quantity) {
        if (stock < quantity)
            throw new IllegalArgumentException("Not enough stock.");
        stock -= quantity;

    }

    public int getStock() {
        return stock;
    }

    @Override
    public void deliver(String email, String address) {
        deliveryStrategy.deliver(email, address);
    }
}
