package shop;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String address;
    private List<Order> orders;
    private int loyaltyPoints;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        loyaltyPoints += order.getItems().stream()
            .mapToInt(Item::getLoyaltyPoints).sum();
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}
