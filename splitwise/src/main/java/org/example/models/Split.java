package org.example.models;

import java.util.List;

public abstract class Split {
    private User payer;
    private List<User> consumers;
    private Double amount;
    public Split(User payer, List<User> consumers, Double amount) {
        this.payer = payer;
        this.consumers = consumers;
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public List<User> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<User> consumers) {
        this.consumers = consumers;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
