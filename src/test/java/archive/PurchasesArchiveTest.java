package archive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;
import shop.StandardItem;

import javax.sound.midi.SysexMessage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PurchasesArchiveTest {
    private PurchasesArchive archive;
    private ByteArrayOutputStream fakeOutput;

    private String randomString(Random rnd) {
        int length = rnd.nextInt(10) + 10;

        byte[] bytes = new byte[length];
        rnd.nextBytes(bytes);
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (bytes[i] % ('Z' - 'A') + 'A');
        }

        return new String(bytes, 0 ,length);
    }

    private Item randomItem() {
        Random rnd = new Random();
        int id = rnd.nextInt();
        String name = randomString(rnd);
        float price = rnd.nextFloat();
        String category = randomString(rnd);
        int loyaltyPoints = 5;

        return new StandardItem(id, name, price, category, loyaltyPoints);
    }

    @Before
    public void setUp() throws Exception {
        archive = new PurchasesArchive();

        fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));
    }

    @After
    public void tearDown() throws Exception {
        archive = null;
        System.setOut(System.out);
    }

    @Test
    public void printItemPurchaseStatistics() {
        StandardItem item = new StandardItem(1, "Josef", 10, "Novak", 5);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);
        ShoppingCart cart = new ShoppingCart(items);
        Order order = new Order(cart, "Jan", "Praha");
        archive.putOrderToPurchasesArchive(order);

        String expected = "ITEM PURCHASE STATISTICS:\n"
                + "ITEM  Item   ID 1   NAME Josef   CATEGORY Novak   PRICE 10.0   LOYALTY POINTS 5   HAS BEEN SOLD 0 TIMES\n";
        String result = "";

        archive.printItemPurchaseStatistics();

        try {
            result = fakeOutput.toString("UTF-8");
        } catch (Exception e) {
            fail("Output cannot be converted to String");
        }

        assertEquals( expected, result);
    }

    @Test
    public void getHowManyTimesHasBeenItemSold() {
        ArrayList<Item> items = IntStream.of(1, 1, 1, 2, 3, 4).mapToObj( (int value) -> {
            return new StandardItem(value, "Name", 12, "Category", 3);
        }).collect(Collectors.toCollection(ArrayList<Item>::new));

        ShoppingCart cart = new ShoppingCart(items);
        Order order = new Order(cart, "Firstname Lastname", "Address");
        archive.putOrderToPurchasesArchive(order);

        int expected = (int) items.stream()
                .filter(item -> { return item.getID() == 1; })
                .count();
        assertEquals(expected, archive.getHowManyTimesHasBeenItemSold(items.get(0)));
    }

    @Test
    public void putOrderToPurchasesArchive() {

    }
}