package org.example.service;

import org.example.models.Expense;
import org.example.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private final List<Expense> expenses = new ArrayList<>();
    public ExpenseManager() {
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String showBalanceForUser(User user) {
        Map<User, Double> userBalance = new HashMap<>();

        expenses.forEach(expense -> {
            User payer = expense.getSplit().getPayer();
            List<User> consumers = expense.getSplit().getConsumers();
            List<Double> consumerShares = expense.getConsumerShare();

            if(payer.equals(user)) {
                for(int i = 0; i < consumers.size(); i++) {
                    if(!consumers.get(i).equals(user)) {
                        settleShare(consumers.get(i), consumerShares.get(i), userBalance);
                    }
                }
            } else {
                for(int i = 0; i < consumers.size(); i++) {
                    if(consumers.get(i).equals(user)) {
                        settleShare(payer, consumerShares.get(i) * (-1), userBalance);
                    }
                }
            }
        });

        StringBuilder stringBuilder = new StringBuilder();

        userBalance.forEach((consumer, amount) -> {
            if(amount < 0) {
                appendBalance(consumer, user, amount, stringBuilder);
            } else if(amount > 0) {
                appendBalance(user, consumer, amount, stringBuilder);
            }
        });

        String balance = stringBuilder.toString();
        if(balance.length() == 0) {
            return "No Balance";
        }
        return balance;
    }

    private void appendBalance(User payer, User consumer, Double amount, StringBuilder stringBuilder) {
        stringBuilder.append(consumer.getName())
                .append(" owes ")
                .append(payer.getName())
                .append(" ")
                .append(Math.abs(amount))
                .append('\n');
    }

    private void settleShare(User consumer, Double amount, Map<User, Double> userBalance) {
        userBalance.put(consumer, userBalance.getOrDefault(consumer, (double) 0) + amount);
    }
}
