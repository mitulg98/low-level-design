package org.example.service;

import org.example.factory.ExpenseFactory;
import org.example.models.*;

import java.util.*;
import java.util.stream.Collectors;

public class ExpenseManager {
    private final List<Expense> expenses = new ArrayList<>();
    private final UserPool userPool = new UserPool();
    private final Map<String, Map<String, Double>> balanceSheet = new HashMap<>();

    public ExpenseManager() {
    }

    public User getUserByUserId(String id) {
        return userPool.getUserById(id);
    }

    public void addUser(String id, String name, String contact, String email) {
        userPool.addUser(new User(id, name, contact, email));
    }

    public void addExpense(ExpenseType expenseType, ExpenseMetadata expenseMetadata, String payerId, Double amount, List<String> consumerIds, List<Double> distribution) {
        List<User> consumers = consumerIds.stream()
                .map(userPool::getUserById)
                .collect(Collectors.toList());

        Expense expense = ExpenseFactory.createExpense(expenseType, expenseMetadata, userPool.getUserById(payerId), amount, consumers, distribution);

        if (Objects.isNull(expense)) {
            return;
        }

        expenses.add(expense);
        balanceSheet.putIfAbsent(payerId, new HashMap<>());

        for(Split split: expense.getSplits()) {
            User consumer = split.getUser();

            if(consumer.getId().equals(payerId)) {
                continue;
            }

            Map<String, Double> payerBalanceSheet = balanceSheet.get(payerId);
            payerBalanceSheet.put(consumer.getId(), payerBalanceSheet.getOrDefault(consumer.getId(), 0.0) + split.getAmount());

            balanceSheet.putIfAbsent(consumer.getId(), new HashMap<>());
            Map<String, Double> consumerBalanceSheet = balanceSheet.get(consumer.getId());
            consumerBalanceSheet.put(payerId, consumerBalanceSheet.getOrDefault(payerId, 0.0) - split.getAmount());
        }
    }

    public String showBalance() {
        List<User> users = userPool.getUsers();

        StringBuilder stringBuilder = new StringBuilder();

        for(User user: users) {
            stringBuilder.append(showBalanceForUser(user.getId()));
        }

        return stringBuilder.toString();
    }

    public String showBalanceForUser(String userId) {
        User user = userPool.getUserById(userId);
        Map<String, Double> userBalanceSheet = balanceSheet.getOrDefault(user.getId(), Collections.emptyMap());
        StringBuilder stringBuilder = new StringBuilder();

        userBalanceSheet.forEach((consumerId, amount) -> {
            if(amount < 0) {
                appendBalance(userPool.getUserById(consumerId), user, amount, stringBuilder);
            } else if(amount > 0) {
                appendBalance(user, userPool.getUserById(consumerId), amount, stringBuilder);
            }
        });

        if(userBalanceSheet.isEmpty()) {
            stringBuilder.append("No balance for user ")
                    .append(user.getName())
                    .append("\n");
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    private void appendBalance(User payer, User consumer, Double amount, StringBuilder stringBuilder) {
        stringBuilder.append(consumer.getName())
                .append(" owes ")
                .append(payer.getName())
                .append(" ")
                .append(Math.abs(amount))
                .append('\n');
    }
}
