package Strategy_Pattern_for_Delivery;

public class NoDeliveryStrategy implements DeliveryStrategy{

    @Override
    public void deliver(String email, String address) {
        System.out.println("Quantum book store: This book is not for sale.");
    }
}
