package org.vendingMachine;

import java.util.List;

public class Inventory {
    private final List<ItemShelf> shelves;

    public Inventory(List<ItemShelf> shelves) {
        this.shelves = shelves;
        logInventory(shelves);
    }

    private void logInventory(List<ItemShelf> shelves) {
        for(ItemShelf shelf: shelves) {
            System.out.println("Code : " + shelf.getCode() +
                    " Item : " + shelf.getItem().getName() +
                    " Price : " + shelf.getItem().getPrice() +
                    " IsSoldOut : " + shelf.isSoldOut());
        }
    }

    public Item getItem(int code) {
        List<Item> items = shelves.stream()
                .filter(itemShelf -> itemShelf.getCode() == code)
                .map(ItemShelf::getItem)
                .toList();

        if(!items.isEmpty()) {
            return items.get(0);
        }

        return null;
    }

    public boolean sellItem(int code) {
        List<ItemShelf> itemShelves = shelves.stream()
                .filter(itemShelf -> itemShelf.getCode() == code)
                .toList();

        if(!itemShelves.isEmpty()) {
            ItemShelf itemShelf = itemShelves.get(0);
            if(!itemShelf.isSoldOut()) {
                itemShelf.setSoldOut(true);
                return true;
            }
        }

        return false;
    }

    public boolean updateInventory(Item item, int code) {
        List<ItemShelf> itemShelves = shelves.stream()
                .filter(itemShelf -> itemShelf.getCode() == code)
                .toList();

        if(itemShelves.isEmpty()) {
            ItemShelf itemShelf = new ItemShelf(code, false, item);
            shelves.add(itemShelf);
            logInventory(shelves);
            return true;
        } else {
            ItemShelf itemShelf = itemShelves.get(0);
            if(!itemShelf.isSoldOut()) {
                return false;
            } else {
                itemShelf.setSoldOut(false);
                itemShelf.setItem(item);
                logInventory(shelves);
                return true;
            }
        }
    }
}
