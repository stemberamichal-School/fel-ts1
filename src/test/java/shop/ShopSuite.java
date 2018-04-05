package shop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ItemTest.class,
    DiscountedItemTest.class
})
public class ShopSuite {
}
