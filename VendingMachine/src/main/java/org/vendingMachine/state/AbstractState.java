package org.vendingMachine.state;

import org.vendingMachine.VendingMachine;

public abstract class AbstractState implements State {
    final VendingMachine vendingMachine;

    public AbstractState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
