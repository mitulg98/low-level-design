package org.example.factory;

import jdk.jfr.Percentage;
import org.example.models.*;
import org.example.models.expense.EqualExpense;
import org.example.models.expense.ExactExpense;
import org.example.models.expense.PercentageExpense;
import org.example.models.split.EqualSplit;
import org.example.models.split.ExactSplit;
import org.example.models.split.PercentageSplit;

import java.util.ArrayList;
import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseType expenseType, ExpenseMetadata expenseMetadata, User payer, Double amount, List<User> consumers, List<Double> distribution) {
        switch (expenseType) {
            case EXACT -> {
                List<Split> splits = new ArrayList<>();
                for(int i = 0; i < consumers.size(); i++) {
                    Split split = new ExactSplit(consumers.get(i), distribution.get(i));
                    splits.add(split);
                }
                return new ExactExpense(expenseMetadata, splits, amount, payer);
            }
            case EQUAL -> {
                List<Split> splits = new ArrayList<>();
                double splitAmount = Math.round(amount * 100 / consumers.size()) / 100.0;
                for (User consumer : consumers) {
                    Split split = new EqualSplit(consumer);
                    split.setAmount(splitAmount);
                    splits.add(split);
                }
                splits.get(0).setAmount(splits.get(0).getAmount() + amount - splitAmount * consumers.size());
                return new EqualExpense(expenseMetadata, splits, amount, payer);
            }
            case PERCENTAGE -> {
                List<Split> splits = new ArrayList<>();
                for(int i = 0; i < consumers.size(); i++) {
                    PercentageSplit split = new PercentageSplit(consumers.get(i), distribution.get(i));
                    split.setAmount((amount * split.getPercentage()) / 100.0);
                    splits.add(split);
                }
                return new EqualExpense(expenseMetadata, splits, amount, payer);
            }
            default -> {
                return null;
            }
        }
    }
}
