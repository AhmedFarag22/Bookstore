package model;

import Strategy_Pattern_for_Delivery.DeliveryStrategy;
import Strategy_Pattern_for_Delivery.NoDeliveryStrategy;

public class ShowcaseBook extends Book{

    public ShowcaseBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author, new NoDeliveryStrategy());
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void deliver(String email, String address) {
        deliveryStrategy.deliver(email, address);
    }
}
