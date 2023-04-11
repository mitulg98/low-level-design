package org.vendingMachine.state;

import org.vendingMachine.Inventory;
import org.vendingMachine.Item;
import org.vendingMachine.Money;
import org.vendingMachine.VendingMachine;

import java.util.Collections;

public class Selection extends AbstractState {
    public Selection(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void clickInsertCashButton() {
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public void addMoney(Money money) {
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public void goToSelectionMenu() {
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public Money cancelAndTakeRefund() {
        System.out.println("Generating Refund");
        vendingMachine.setState(new Idle(vendingMachine));
        Money refund = vendingMachine.getCurrentTransAmt();
        vendingMachine.setCurrentTransAmt(new Money(Collections.emptyList()));
        return refund;
    }

    @Override
    public boolean selectProduct(int code) {
        Inventory inventory = vendingMachine.getInventory();
        Item item = inventory.getItem(code);

        if(item == null || item.getPrice() > vendingMachine.getCurrentTransAmt().getTotalAmount()) {
            return false;
        }

        return inventory.sellItem(code);
    }

    @Override
    public Item dispenseProduct() {
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public Money getChange() {
        throw new UnsupportedOperationException("This operation is not allowed");
    }
}
