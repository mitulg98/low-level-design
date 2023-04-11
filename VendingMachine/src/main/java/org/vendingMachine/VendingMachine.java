package org.vendingMachine;

import org.vendingMachine.state.Idle;
import org.vendingMachine.state.State;
import org.vendingMachine.state.Submission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {
    private State state;
    private Money currentTransAmt;
    private final Inventory inventory;
    private final CashCarrier cashCarrier;
    private int selectedItem;

    public VendingMachine() {
        this.state = new Idle(this);
        this.inventory = initializeInventory();
        this.cashCarrier = new CashCarrier();
    }

    private Inventory initializeInventory() {
        System.out.println("------ Initializing Vending Machine ------");
        List<ItemShelf> shelves = new ArrayList<>();
        Item item1 = new Item(10, "Coke");
        Item item2 = new Item(20, "Pepsi");
        Item item3 = new Item(30, "Soda");
        Item item4 = new Item(40, "Chips");
        shelves.add(new ItemShelf(101, false, item1));
        shelves.add(new ItemShelf(102, false, item2));
        shelves.add(new ItemShelf(103, false, item4));
        shelves.add(new ItemShelf(104, false, item3));
        shelves.add(new ItemShelf(105, false, item2));
        shelves.add(new ItemShelf(106, false, item1));
        shelves.add(new ItemShelf(107, false, item3));
        shelves.add(new ItemShelf(108, false, item4));
        shelves.add(new ItemShelf(109, false, item2));
        return new Inventory(shelves);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCurrentTransAmt(Money money) {
        this.currentTransAmt = money;
    }

    public Money getCurrentTransAmt() {
        return currentTransAmt;
    }

    public void clickInsertCashButton() {
        state.clickInsertCashButton();
    }

    public void addMoney(Money money) {
        state.addMoney(money);
    }

    public void goToSelectionMenu() {
        state.goToSelectionMenu();
    }

    public void selectProduct(int code) {
        boolean isProductSelected = state.selectProduct(code);

        if(!isProductSelected) {
            throw new IllegalArgumentException("Product cannot be selected.");
        } else {
            setState(new Submission(this));
            setSelectedItem(code);
            cashCarrier.addCash(currentTransAmt);
        }
    }

    public Money cancelAndTakeRefund() {
        return state.cancelAndTakeRefund();
    }

    public Money getChange() {
        Money money = state.getChange();
        System.out.println("Generated Change : " + money.getTotalAmount());
        return money;
    }

    public Item dispenseProduct() {
        Item dispensedProduct = state.dispenseProduct();
        System.out.println("Dispensing item : " + dispensedProduct.getName());
        setState(new Idle(this));
        return dispensedProduct;
    }

    public void updateInventory(Item item, int code) {
        System.out.println("Updating inventory");
        boolean isUpdated = inventory.updateInventory(item, code);
        if(!isUpdated) {
            throw new IllegalArgumentException("Couldn't update inventory with this item and code.");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public CashCarrier getCashCarrier() {
        return cashCarrier;
    }

    public void setSelectedItem(int code) {
        selectedItem = code;
    }

    public int getSelectedItem() {
        return selectedItem;
    }
}
