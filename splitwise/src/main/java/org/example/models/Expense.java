package org.example.models;

import java.util.List;

public abstract class Expense {
    private ExpenseMetadata expenseMetadata;
    private List<Split> splits;
    private Double amount;
    private User payer;
    private String id;

    public Expense(ExpenseMetadata expenseMetadata, List<Split> splits, Double amount, User payer) {
        this.expenseMetadata = expenseMetadata;
        this.splits = splits;
        this.amount = amount;
        this.payer = payer;
    }

    public ExpenseMetadata getExpenseMetadata() {
        return expenseMetadata;
    }

    public void setExpenseMetadata(ExpenseMetadata expenseMetadata) {
        this.expenseMetadata = expenseMetadata;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public String getId() {
        return id;
    }

    public abstract Boolean isExpenseValid();
}
