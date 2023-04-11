package org.vendingMachine.state;

import org.vendingMachine.Item;
import org.vendingMachine.Money;
import org.vendingMachine.VendingMachine;

import java.util.Collections;

public class AcceptingMoney extends AbstractState {
    public AcceptingMoney(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void clickInsertCashButton() {
        throw new UnsupportedOperationException("This operation is not allowed");
    }

    @Override
    public void addMoney(Money money) {
        System.out.println("Accepting Money : " + money.getTotalAmount());
        vendingMachine.setCurrentTransAmt(money);
    }

    @Override
    public void goToSelectionMenu() {
        System.out.println("Moving to selection menu");
        vendingMachine.setState(new Selection(vendingMachine));
    }

    @Override
    public Money cancelAndTakeRefund() {
        System.out.println("Generating refund");
        vendingMachine.setState(new Idle(vendingMachine));
        Money refund = vendingMachine.getCurrentTransAmt();
        vendingMachine.setCurrentTransAmt(new Money(Collections.emptyList()));
        return refund;
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
