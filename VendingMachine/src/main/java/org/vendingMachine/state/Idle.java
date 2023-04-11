package org.vendingMachine.state;

import org.vendingMachine.Item;
import org.vendingMachine.Money;
import org.vendingMachine.VendingMachine;

import java.util.Collections;

public class Idle extends AbstractState {
    public Idle(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void clickInsertCashButton() {
        System.out.println("Now accepting money.");
        vendingMachine.setState(new AcceptingMoney(vendingMachine));
        vendingMachine.setSelectedItem(-1);
        vendingMachine.setCurrentTransAmt(new Money(Collections.emptyList()));
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
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public Money getChange() {
        throw new UnsupportedOperationException("This operation is not allowed");
    }
}
