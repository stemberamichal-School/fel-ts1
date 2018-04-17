package shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardItemTest {

    private StandardItem item;

    @Before
    public void setUp() throws Exception {
        item = new StandardItem(1, "Test item", 20, "Test category", 2);
    }

    @After
    public void tearDown() throws Exception {
        item = null;
    }

    @Test
    public void equals() {
        StandardItem differentItem = new StandardItem(2, "Second item", 30, "Another test category", 4);
        StandardItem sameItem = new StandardItem(item.id, item.name, item.price, item.category, item.getLoyaltyPoints());

        assertNotEquals(item, differentItem);
        assertEquals(item, item);
        assertEquals(item, sameItem);
    }

    @Test
    public void copy() {
        StandardItem item2 = item.copy();

        assertFalse(item == item2);
        assertEquals(item, item2);

        assertEquals(item.id, item2.id);
        assertEquals(item.name, item2.name);
        assertEquals(item.price, item2.price, 0.0001);
        assertEquals(item.category, item2.category);
        assertEquals(item.getLoyaltyPoints(), item2.getLoyaltyPoints());
    }
}