package org.example.models;

import java.util.List;

public abstract class Expense {
    private ExpenseType expenseType;
    private ExpenseMetadata expenseMetadata;
    private Split split;

    public Expense(ExpenseType expenseType, ExpenseMetadata expenseMetadata, Split split) {
        this.expenseType = expenseType;
        this.expenseMetadata = expenseMetadata;
        this.split = split;
    }

    public abstract List<Double> getConsumerShare();

    public abstract Boolean isExpenseValid();

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public ExpenseMetadata getExpenseMetadata() {
        return expenseMetadata;
    }

    public void setExpenseMetadata(ExpenseMetadata expenseMetadata) {
        this.expenseMetadata = expenseMetadata;
    }

    public Split getSplit() {
        return split;
    }

    public void setSplit(Split split) {
        this.split = split;
    }
}
