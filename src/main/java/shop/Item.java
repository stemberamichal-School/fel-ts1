package shop;



/**
 * The basic class for item in the EShop.
 */


public abstract class Item implements ItemInterface {
    protected int id;
    protected String name;
    protected float price;
    protected String category;
    
    public Item(int id, String name, float price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Item   ID "+id+"   NAME "+name+"   CATEGORY "+category;
    }
    
    @Override
    public int getID() {
        return id;
    }
    
    @Override
    public void setID(int id) {
        this.id = id;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public float getPrice() {
        return price;
    }
    
    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getCategory() {
        return this.category;
    }
    
    @Override
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof Item){
            Item zbozi = (Item) object;
            if( id == zbozi.getID()
                && name.equals(zbozi.getName())
                && price == zbozi.getPrice()
                && category.equals(zbozi.getCategory())
               ) {
                return true;
            }
        }
        return false;
    }
}

