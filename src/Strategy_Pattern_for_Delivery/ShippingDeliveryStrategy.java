package Strategy_Pattern_for_Delivery;

public class ShippingDeliveryStrategy implements DeliveryStrategy{

    @Override
    public void deliver(String email, String address) {
        System.out.println("Quantum book store: Shipping book to " + address);
    }
}
