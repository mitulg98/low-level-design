package org.example.models.expense;

import org.example.models.*;
import org.example.models.split.EqualSplit;

import java.util.ArrayList;
import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(ExpenseMetadata expenseMetadata, List<Split> splits, Double amount, User payer) {
        super(expenseMetadata, splits, amount, payer);
    }

    @Override
    public Boolean isExpenseValid() {
        for(Split split: getSplits()) {
            if(!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
