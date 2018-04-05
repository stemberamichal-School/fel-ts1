package shop;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Date;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DiscountedItemTest {

    private DiscountedItem item;

    @Before
    public void setUp() throws Exception {
//        arrange
        item = new DiscountedItem(1, "Tričko", 100, "Oblečení", 0, "20.3.2018", "25.3.2018");
    }

    @Test
    public void getDiscountedPrice() {
//      assert
        assertEquals(100, item.getDiscountedPrice(), 1e-5);
//        act
        item.setDiscount(10);
//      assert
        assertEquals(90, item.getDiscountedPrice(), 1e-5);
    }

    @Test
    public void testEquals() {
        Item item1 = new DiscountedItem(0, "talir", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");
        Item item2 = new DiscountedItem(0, "talir", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");

        assertEquals(item1, item2);
    }

    @Test
    public void testNotEquals() {
        Item item1 = new DiscountedItem(0, "talir", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");
        Item item2 = new DiscountedItem(1, "vidlicka", (float) 40, "pribor", 30, "20.05.2019", "30.05.2019");

        assertNotEquals(item1, item2);

        item1 = new DiscountedItem(1, "talir", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");
        item2 = new DiscountedItem(0, "talir", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");

        assertNotEquals(item1, item2);

        item1 = new DiscountedItem(0, "talire", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");
        item2 = new DiscountedItem(0, "talir", (float) 30, "nadobi", 20, "20.05.2018", "30.05.2018");

        assertNotEquals(item1, item2);
    }
}