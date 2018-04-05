package shop;

public interface ItemInterface {
    String toString();

    int getID();

    void setID(int id);

    String getName();

    void setName(String name);

    float getPrice();

    void setPrice(float price);

    String getCategory();

    void setCategory(String category);

    boolean equals(Object object);
}
