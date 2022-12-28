package org.example.models.expense;

import jdk.jfr.Percentage;
import org.example.models.*;
import org.example.models.split.PercentageSplit;

import java.util.List;
import java.util.stream.Collectors;

public class PercentageExpense extends Expense {

    public PercentageExpense(ExpenseMetadata expenseMetadata, List<Split> splits, Double amount, User payer) {
        super(expenseMetadata, splits, amount, payer);

        if(!isExpenseValid()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Boolean isExpenseValid() {
        for(Split split: getSplits()) {
            if(!(split instanceof PercentageSplit)) {
                return false;
            }
        }

        return getSplits().stream()
                .map(PercentageSplit.class::cast)
                .map(PercentageSplit::getPercentage)
                .reduce(0.0, Double::sum)
                .equals(100.0);
    }
}
