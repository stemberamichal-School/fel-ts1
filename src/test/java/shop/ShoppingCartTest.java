package shop;

import helpers.ItemStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() throws Exception {
       cart = new ShoppingCart();
    }

    @Test
    public void getItemsCount() {
//        arrange
        Item item = new ItemStub();
//        assert
        assertEquals(0, cart.getItemsCount());
//        act
        cart.addItem(item);
//        assert
        assertEquals(1, cart.getItemsCount());
    }

    @Test
    public void getTotalPrice() {
//        Item item = new ItemStub();
        Item mockedItem = mock(Item.class);
        when(mockedItem.getPrice()).thenReturn((float) 20);
        cart.addItem(mockedItem);

        assertEquals(20, cart.getTotalPrice());
//        verify(mockedItem, times(2)).getPrice();
        verify(mockedItem, times(1)).getPrice();
        verify(mockedItem, never()).setPrice(anyFloat());
    }
}