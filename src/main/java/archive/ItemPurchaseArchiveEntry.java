package archive;

import shop.Item;
import shop.ItemInterface;

class ItemPurchaseArchiveEntry {
    private ItemInterface refItem;
    private int soldCount;
    
    ItemPurchaseArchiveEntry(ItemInterface refItem) {
        this.refItem = refItem;
        soldCount = 0;
    }
    
    void increaseCountHowManyTimesHasBeenSold(int x) {
        soldCount += x;
    }
    
    int getCountHowManyTimesHasBeenSold() {
        return soldCount;
    }
    
    ItemInterface getRefItem() {
        return refItem;
    }
    
    @Override
    public String toString() {
        return "ITEM  "+refItem.toString()+"   HAS BEEN SOLD "+soldCount+" TIMES";
    }
}
