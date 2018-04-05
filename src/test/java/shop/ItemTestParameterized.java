package shop;

import helpers.CSVfileReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ItemTestParameterized {

    private int id;
    private String name;
    private float price;
    private String category;
    private boolean isSame;

    private StandardItem item;

    public ItemTestParameterized(String id, String name, String price, String category, String isSame) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.price = Float.parseFloat(price);
        this.category = category;
        System.out.println(isSame);
        this.isSame = Boolean.parseBoolean(isSame);
        System.out.println(this.isSame);
    }

    @Before
    public void setUp() throws Exception {
        item = new StandardItem(id, name, price, category, 0);
    }

    @Test
    public void testGetCategory() {
        System.out.println(this.category);
        assertEquals(this.category, item.getCategory());
    }

    @Test
    public void testGetName() {
        System.out.println(this.name);
        assertEquals(this.name, item.getName());
    }

    @Test
    public void testEquals() {
        Item other = new StandardItem(1, "zarovka", 30, "domaci potreby", 0);
        if (isSame) {
            assertEquals(other, this.item);
        } else {
            assertNotEquals(other, this.item);
        }
    }

    @Parameterized.Parameters(name="input id: {0}, input name: {1}, category: {3}, price: {2}")
    public static Collection<String[]> data() throws IOException {
        return CSVfileReader.readCSVfileToCollection("C:\\Users\\Azathoth\\IdeaProjects\\unittests\\src\\test\\resources\\data.csv");
    }

}
