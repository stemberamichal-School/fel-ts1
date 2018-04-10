package processes;

import org.junit.Before;
import org.junit.Test;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;
import shop.StandardItem;
import storage.NoItemInStorage;
import storage.Storage;
import static org.junit.Assert.*;

public class EshopCartTestTDL2 {

    private Storage storage;
    private ShoppingCart cart;
    private Item item;
    private static final int ITEM_ID = 1;

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
        cart = new ShoppingCart();

        item = new StandardItem(ITEM_ID, "Lenovo notebook", 15000, "notebook", 5);
    }

    @Test
    public void testCase1() throws NoItemInStorage {
//        1
        storage.insertItems(item, 2);

        assertEquals(2, storage.getItemCount(item));
        assertEquals(0, cart.getItemsCount());
//        2
        cart.addItem(item);
        assertEquals(1, cart.getItemsCount());
//        3
        cart.removeItem(ITEM_ID);
        assertEquals(0, cart.getItemsCount());
//        2
        cart.addItem(item);
        assertEquals(1, cart.getItemsCount());
//        4
        Order order = new Order(cart, "Test User 1", "Test address 1");
        storage.processOrder(order);
        assertEquals(1, storage.getItemCount(item));
    }

    @Test(expected = NoItemInStorage.class)
    public void testCase2() throws NoItemInStorage {
//        1
        storage.insertItems(item, 0);

        assertEquals(0, storage.getItemCount(item));
        assertEquals(0, cart.getItemsCount());
//        3
        cart.removeItem(ITEM_ID);
        assertEquals(0, cart.getItemsCount());
//        2
        cart.addItem(item);
        Item item2 = new StandardItem(3, "Lenovo notebook", 15000, "notebook", 5);
        cart.addItem(item2);
        assertEquals(2, cart.getItemsCount());
//        3
        cart.removeItem(ITEM_ID);
        assertEquals(1, cart.getItemsCount());
//        4
        Order order = new Order(cart, "Test User 2", "Test address 2");
        storage.processOrder(order);
    }

    @Test
    public void testCase3() throws NoItemInStorage {
        //        1
        storage.insertItems(item, 0);

        assertEquals(0, storage.getItemCount(item));
        assertEquals(0, cart.getItemsCount());
//        4
        Order order = new Order(cart, "Test User 3", "Test address 3");
        storage.processOrder(order);

    }
}
