package storage;

import helpers.ItemStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Item;

import static org.junit.Assert.*;

public class ItemStockTest {

    private Item refItem;
    private ItemStock itemStock;

    @Before
    public void setUp() throws Exception {
        refItem = new ItemStub();
        itemStock = new ItemStock(refItem);
    }

    @After
    public void tearDown() throws Exception {
        refItem = null;
        itemStock = null;
    }

    @Test
    public void increaseItemCount() {
        int count = itemStock.getCount();

        int increaseCount = 10;
        itemStock.IncreaseItemCount(increaseCount);
        assertEquals(count + increaseCount, itemStock.getCount());

        count = itemStock.getCount();
        itemStock.IncreaseItemCount(0);
        assertEquals(count, itemStock.getCount());

        int decreaseCount = -10;
        itemStock.IncreaseItemCount(decreaseCount);
        assertEquals(count + decreaseCount, itemStock.getCount());
    }

    @Test
    public void decreaseItemCount() {
        int count = itemStock.getCount();

        int decreaseCount = 10;
        itemStock.decreaseItemCount(decreaseCount);
        assertEquals(count - decreaseCount, itemStock.getCount());

        count = itemStock.getCount();
        itemStock.IncreaseItemCount(0);
        assertEquals(count, itemStock.getCount());

        int increaseCount = -10;
        itemStock.IncreaseItemCount(increaseCount);
        assertEquals(count + increaseCount, itemStock.getCount());
    }
}