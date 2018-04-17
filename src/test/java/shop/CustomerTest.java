package shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("test customer", "test address");
    }

    @Test
    public void getLoyaltyPointsEmpty() {
        assertEquals(0, customer.getLoyaltyPoints());
    }

    @Test
    public void getLoyaltyPointsOneOrder() {
        Item item = new StandardItem(1, "tričko", 300, "oblečení", 2);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item);
        Order order = new Order(cart, customer.getName(), customer.getAddress());
        customer.addOrder(order);

        assertEquals(2, customer.getLoyaltyPoints());
    }

    @Test
    public void getLoyaltyPointsTwoOrders() {
        Item item1 = new StandardItem(1, "tričko", 300, "oblečení", 2);
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem(item1);
        Order order1 = new Order(cart1, customer.getName(), customer.getAddress());

        Item item2 = new StandardItem(1, "nike boty", 1500, "boty", 5);
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(item2);
        Order order2 = new Order(cart2, customer.getName(), customer.getAddress());

        customer.addOrder(order1);
        customer.addOrder(order2);

        assertEquals(7, customer.getLoyaltyPoints());
    }
}