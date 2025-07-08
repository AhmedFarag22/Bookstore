package model;

import Strategy_Pattern_for_Delivery.DeliveryStrategy;
import Strategy_Pattern_for_Delivery.EmailDeliveryStrategy;

public class EBook extends Book{
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author, String fileType) {
        super(isbn, title, year, price, author, new EmailDeliveryStrategy());

        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void deliver(String email, String address) {
        deliveryStrategy.deliver(email, address);
    }
}
