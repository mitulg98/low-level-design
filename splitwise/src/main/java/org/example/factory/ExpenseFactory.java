package org.example.factory;

import org.example.models.*;
import org.example.models.expense.EqualExpense;
import org.example.models.expense.ExactExpense;
import org.example.models.expense.PercentageExpense;
import org.example.models.split.EqualSplit;
import org.example.models.split.ExactSplit;
import org.example.models.split.PercentageSplit;

import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseType expenseType, User payer, List<User> consumers, List<Double> distribution, Double amount, String expenseName, String expenseNotes, String expenseImage) {
        ExpenseMetadata expenseMetadata = new ExpenseMetadata(expenseName, expenseNotes, expenseImage);

        switch (expenseType) {
            case EXACT -> {
                ExactSplit exactSplit = new ExactSplit(payer, consumers, amount, distribution);
                return new ExactExpense(expenseMetadata, exactSplit);
            }
            case EQUAL -> {
                EqualSplit equalSplit = new EqualSplit(payer, consumers, amount);
                return new EqualExpense(expenseMetadata, equalSplit);
            }
            case PERCENTAGE -> {
                PercentageSplit percentageSplit = new PercentageSplit(payer, consumers, amount, distribution);
                return new PercentageExpense(expenseMetadata, percentageSplit);
            }
        }

        return null;
    }
}
