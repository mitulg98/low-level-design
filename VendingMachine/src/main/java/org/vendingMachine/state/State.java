package org.vendingMachine.state;

import org.vendingMachine.Item;
import org.vendingMachine.Money;

public interface State {
    void clickInsertCashButton();
    void addMoney(Money money);
    void goToSelectionMenu();
    Money cancelAndTakeRefund();
    boolean selectProduct(int code);
    Item dispenseProduct();
    Money getChange();
}
