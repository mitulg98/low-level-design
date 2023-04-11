package org.vendingMachine;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // 1st operation
        vendingMachine.clickInsertCashButton();
        Money money = new Money(Arrays.asList(Note.TEN, Note.TWENTY));
        vendingMachine.addMoney(money);
        vendingMachine.goToSelectionMenu();
        vendingMachine.selectProduct(102);
        money = vendingMachine.getChange();
        Item item = vendingMachine.dispenseProduct();

        // 2nd operation
        vendingMachine.clickInsertCashButton();
        money = new Money(List.of(Note.FIFTY));
        vendingMachine.addMoney(money);
        vendingMachine.goToSelectionMenu();
        vendingMachine.selectProduct(107);
        money = vendingMachine.getChange();
        item = vendingMachine.dispenseProduct();

        vendingMachine.updateInventory(new Item(20, "Fanta"), 102);

        // 2nd operation
        vendingMachine.clickInsertCashButton();
        money = new Money(List.of(Note.TWENTY));
        vendingMachine.addMoney(money);
        vendingMachine.goToSelectionMenu();
        vendingMachine.selectProduct(102);
        money = vendingMachine.getChange();
        item = vendingMachine.dispenseProduct();
    }
}