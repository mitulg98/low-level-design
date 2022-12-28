package org.example.models.expense;

import org.example.models.Expense;
import org.example.models.ExpenseMetadata;
import org.example.models.ExpenseType;
import org.example.models.Split;
import org.example.models.split.PercentageSplit;

import java.util.List;
import java.util.stream.Collectors;

public class PercentageExpense extends Expense {
    public PercentageExpense(ExpenseMetadata expenseMetadata, Split split) {
        super(ExpenseType.PERCENTAGE, expenseMetadata, split);

        if(!this.isExpenseValid()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Double> getConsumerShare() {
        PercentageSplit percentageSplit = (PercentageSplit) this.getSplit();
        Double amount = percentageSplit.getAmount();

        return percentageSplit.getPercentageDistribution()
                .stream()
                .map(percentage -> amount * percentage / 100)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean isExpenseValid() {
        PercentageSplit percentageSplit = (PercentageSplit) this.getSplit();

        return percentageSplit.getPercentageDistribution()
                .stream()
                .reduce((double) 0, Double::sum)
                .equals((double) 100) &&
                percentageSplit.getPercentageDistribution().size() == percentageSplit.getConsumers().size();
    }
}
