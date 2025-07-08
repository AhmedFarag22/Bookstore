package Strategy_Pattern_for_Delivery;

public class EmailDeliveryStrategy implements DeliveryStrategy{

    @Override
    public void deliver(String email, String address) {
        System.out.println("Quantum book store: Sending eBook to " + email);
    }
}
