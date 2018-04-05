package archive;

import helpers.ItemStub;
import org.junit.Before;
import org.junit.Test;
import shop.Item;
import shop.ItemInterface;
import shop.StandardItem;

import static org.junit.Assert.*;

public class ItemPurchaseArchiveEntryTest {

    private ItemPurchaseArchiveEntry archiveEntry;

    @Before
    public void setUp() throws Exception {
        ItemInterface item = new ItemStub();
        archiveEntry = new ItemPurchaseArchiveEntry(item);
    }

    @Test
    public void increaseCountHowManyTimesHasBeenSold() {
//        assert
        assertEquals(0, archiveEntry.getCountHowManyTimesHasBeenSold());

//        act
        archiveEntry.increaseCountHowManyTimesHasBeenSold(1);

//        assert
        assertEquals(1, archiveEntry.getCountHowManyTimesHasBeenSold());
    }
}