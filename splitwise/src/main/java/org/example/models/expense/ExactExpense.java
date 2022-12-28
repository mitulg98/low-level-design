package org.example.models.expense;

import org.example.models.*;
import org.example.models.split.ExactSplit;

import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(ExpenseMetadata expenseMetadata, List<Split> splits, Double amount, User payer) {
        super(expenseMetadata, splits, amount, payer);
    }

    @Override
    public Boolean isExpenseValid() {
        for(Split split: getSplits()) {
            if(!(split instanceof ExactSplit)) {
                return false;
            }
        }

        return getSplits().stream()
                .map(Split::getAmount)
                .reduce(0.0, Double::sum)
                .equals(getAmount());
    }
}
