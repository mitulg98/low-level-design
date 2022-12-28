package org.example.models.expense;

import org.example.models.Expense;
import org.example.models.ExpenseMetadata;
import org.example.models.ExpenseType;
import org.example.models.Split;
import org.example.models.split.ExactSplit;

import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(ExpenseMetadata expenseMetadata, Split split) {
        super(ExpenseType.EXACT, expenseMetadata, split);

        if(!this.isExpenseValid()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Double> getConsumerShare() {
        ExactSplit exactSplit = (ExactSplit) this.getSplit();
        return exactSplit.getDistribution();
    }

    @Override
    public Boolean isExpenseValid() {
        ExactSplit exactSplit = (ExactSplit) this.getSplit();

        return exactSplit.getDistribution()
                .stream()
                .reduce((double) 0, Double::sum)
                .equals(exactSplit.getAmount()) &&
                exactSplit.getDistribution().size() == exactSplit.getConsumers().size();
    }
}
