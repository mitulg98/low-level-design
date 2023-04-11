package org.vendingMachine;

public class ItemShelf {
    private final int code;
    private boolean isSoldOut;
    private Item item;

    public ItemShelf(int code, boolean isSoldOut, Item item) {
        this.code = code;
        this.isSoldOut = isSoldOut;
        this.item = item;
    }

    public int getCode() {
        return code;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
