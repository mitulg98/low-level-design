package org.example;

import org.example.models.Expense;
import org.example.models.ExpenseType;
import org.example.models.Split;
import org.example.models.split.EqualSplit;
import org.example.service.ExpenseManager;
import org.example.service.UserPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser("1", "user1", null, null);
        expenseManager.addUser("2", "user2", null, null);
        expenseManager.addUser("3", "user3", null, null);
        expenseManager.addUser("4", "user4", null, null);
        expenseManager.addUser("5", "user5", null, null);
        expenseManager.addUser("6", "user6", null, null);

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> commands = List.of(line.split(" "));
            String commandType = commands.get(0);

            switch(commandType) {
                case "SHOW" -> {
                    if(commands.size() == 1) {
                        System.out.println(expenseManager.showBalance());
                    } else {
                        System.out.println(expenseManager.showBalanceForUser(commands.get(1)));
                    }
                }
                case "EXPENSE" -> {
                    String payerId = commands.get(1);
                    Double amount = Double.parseDouble(commands.get(2));
                    int numberOfConsumers = Integer.parseInt(commands.get(3));
                    String expenseType = commands.get(4 + numberOfConsumers);
                    List<String> consumerIds = new ArrayList<>();
                    List<Double> distribution = new ArrayList<>();
                    switch(expenseType) {
                        case "EQUAL" -> {
                            for(int i = 0; i < numberOfConsumers; i++) {
                                consumerIds.add(commands.get(3 + i));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL, null, payerId, amount, consumerIds, distribution);
                        }
                        case "EXACT" -> {
                            for(int i = 0; i < numberOfConsumers; i++) {
                                consumerIds.add(commands.get(4 + i));
                                distribution.add(Double.parseDouble(commands.get(5 + i + numberOfConsumers)));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, null, payerId, amount, consumerIds, distribution);
                        }
                        case "PERCENTAGE" -> {
                            for(int i = 0; i < numberOfConsumers; i++) {
                                consumerIds.add(commands.get(4 + i));
                                distribution.add(Double.parseDouble(commands.get(5 + i + numberOfConsumers)));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENTAGE, null, payerId, amount, consumerIds, distribution);
                        }
                    }
                }
            }
        }

        expenseManager.addExpense(ExpenseType.EQUAL,
                null,
                "1",
                1000.0,
                List.of("2", "3", "4"),
                null);

        expenseManager.addExpense(ExpenseType.EXACT,
                null,
                "5",
                1000.0,
                List.of("1", "2", "3", "4"),
                List.of(200.0, 300.0, 400.0, 100.0));

        expenseManager.addExpense(ExpenseType.PERCENTAGE,
                null,
                "4",
                1000.0,
                List.of("2", "3", "4", "5"),
                List.of(10.0, 20.0, 40.0, 30.0));

        System.out.println(expenseManager.showBalance());
    }
}