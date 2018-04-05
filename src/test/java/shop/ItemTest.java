package shop;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemTest {

    private StandardItem item;

    @BeforeClass
    public static void classSetup() {
        System.out.println("I'm in class setup");
    }

    @AfterClass
    public static void classTeardown() {
        System.out.println("I'm in class teardown");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("I'm in setup");
        item = new StandardItem(10, "Gambrinus", 20, "Pivo", 5);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("I'm in teardown");
    }

    @Test
    public void getID() {
        System.out.println("I test ID getter");
        item.setID(10);

        assertEquals(10, item.getID());
    }

    @Test
    public void setID() {
        System.out.println("I test ID setter");

    }

    @Test
    public void getName() {
        item.setName("Tričko");

//        assertTrue("Trička".equals(item.getName()));
        assertEquals("Name getter is not working!", "Tričko", item.getName());
    }

    @Test
    public void setName() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void setPrice() {
    }

    @Test
    public void getCategory() {
    }

    @Test
    public void setCategory() {
    }

}