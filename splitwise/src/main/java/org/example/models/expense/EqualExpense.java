package org.example.models.expense;

import org.example.models.*;
import org.example.models.split.EqualSplit;

import java.util.ArrayList;
import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(ExpenseMetadata expenseMetadata, Split split) {
        super(ExpenseType.EQUAL, expenseMetadata, split);
    }

    @Override
    public List<Double> getConsumerShare() {
        EqualSplit equalSplit = (EqualSplit) this.getSplit();
        int numberOfConsumers = equalSplit.getConsumers().size();
        double amount = equalSplit.getAmount();

        List<Double> consumerShare = new ArrayList<>();

        for(int i = 0; i < numberOfConsumers; i++) {
            consumerShare.add(amount / numberOfConsumers);
        }

        return consumerShare;
    }

    @Override
    public Boolean isExpenseValid() {
        return Boolean.TRUE;
    }
}
