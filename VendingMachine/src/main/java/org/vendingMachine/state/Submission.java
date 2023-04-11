package org.vendingMachine.state;

import org.vendingMachine.*;

public class Submission extends AbstractState {
    public Submission(VendingMachine vendingMachine) {
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
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public boolean selectProduct(int code) {
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public Item dispenseProduct() {
        Inventory inventory = vendingMachine.getInventory();
        int code = vendingMachine.getSelectedItem();
        return inventory.getItem(code);
    }

    @Override
    public Money getChange() {
        CashCarrier cashCarrier = vendingMachine.getCashCarrier();
        Inventory inventory = vendingMachine.getInventory();
        int code = vendingMachine.getSelectedItem();

        Item item = inventory.getItem(code);
        int changeAmt = vendingMachine.getCurrentTransAmt().getTotalAmount() - item.getPrice();

        if(cashCarrier.isChangeable(changeAmt)) {
            return cashCarrier.getChange(changeAmt);
        } else {
            throw new RuntimeException("Cannot do change.");
        }
    }
}
