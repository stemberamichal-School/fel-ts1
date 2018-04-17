package helpers;

import shop.Item;
import shop.ItemInterface;

public class ItemStub extends Item implements ItemInterface {

    public ItemStub(int id, String name, float price, String category) {
        super(id, name, price, category);
    }

    public ItemStub() {
       super(0, "stub name", 10, "stub category");
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void setID(int id) {

    }

    @Override
    public String getName() {
        return "stub name";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(float price) {

    }

    @Override
    public String getCategory() {
        return "stub category";
    }

    @Override
    public void setCategory(String category) {

    }

    @Override
    public int getLoyaltyPoints() {
        return 0;
    }
}
