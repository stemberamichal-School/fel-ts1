package shop;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;
    private LocalDateTime setupTime;

    @Before
    public void setUp() throws Exception {
        setupTime = LocalDateTime.now();
        DateTimeFactory.setTest(setupTime);
        order = new Order(new ShoppingCart(), "customer name", "customer address");
    }

    @Test
    public void getCreated() {
        assertEquals(setupTime, order.getCreated());
    }
}