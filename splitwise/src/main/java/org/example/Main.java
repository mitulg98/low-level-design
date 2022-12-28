package org.example;

import org.example.factory.ExpenseFactory;
import org.example.models.ExpenseType;
import org.example.models.User;
import org.example.service.ExpenseManager;
import org.example.service.UserPool;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        UserPool userPool = new UserPool();

        userPool.addUser(new User("user1", "user1", null, null));
        userPool.addUser(new User("user2", "user2", null, null));
        userPool.addUser(new User("user3", "user3", null, null));
        userPool.addUser(new User("user4", "user4", null, null));
        userPool.addUser(new User("user5", "user5", null, null));
        userPool.addUser(new User("user6", "user6", null, null));

        expenseManager.addExpense(ExpenseFactory.createExpense(ExpenseType.EQUAL,
                userPool.getUserById("user1"),
                List.of(userPool.getUserById("user2"), userPool.getUserById("user3"), userPool.getUserById("user4")),
                null,
                1000.0,
                "DMart",
                null,
                null));

        expenseManager.addExpense(ExpenseFactory.createExpense(ExpenseType.EXACT,
                userPool.getUserById("user5"),
                List.of(userPool.getUserById("user1"), userPool.getUserById("user2"), userPool.getUserById("user3"), userPool.getUserById("user4")),
                List.of(200.0, 300.0, 400.0, 100.0),
                1000.0,
                "Dominoes",
                null,
                null));

        System.out.println(expenseManager.showBalanceForUser(userPool.getUserById("user1")));
        System.out.println(expenseManager.showBalanceForUser(userPool.getUserById("user2")));
        System.out.println(expenseManager.showBalanceForUser(userPool.getUserById("user3")));
        System.out.println(expenseManager.showBalanceForUser(userPool.getUserById("user4")));
        System.out.println(expenseManager.showBalanceForUser(userPool.getUserById("user5")));
        System.out.println(expenseManager.showBalanceForUser(userPool.getUserById("user6")));
    }
}