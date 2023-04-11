package org.vendingMachine;

import java.util.*;

public class CashCarrier {
    private final Map<Note, Integer> notes = new HashMap<>();

    public void addCash(Money money) {
        for(Note note: money.getNotes()) {
            int value = note.getValue();
            notes.put(note, notes.getOrDefault(note, 0) + 1);
        }
    }

    public boolean isChangeable(int amount) {
        boolean[] dp = getChangeability(amount);
        return dp[amount];
    }

    public Money getChange(int amount) {
        boolean[] dp = getChangeability(amount);

        if(!dp[amount]) {
            return null;
        }

        int x = amount;

        List<Note> result = new ArrayList<>();

        while(x > 0) {
            for(Map.Entry<Note, Integer> entry: notes.entrySet()) {
                int value = entry.getKey().getValue();
                if(x >= value && dp[x - value]) {
                    x -= value;
                    result.add(entry.getKey());
                    break;
                }
            }
        }

        for(Note note: result) {
            notes.put(note, notes.get(note) - 1);
        }

        return new Money(result);
    }

    private boolean[] getChangeability(int amount) {
        boolean[] dp = new boolean[amount + 1];
        dp[0] = true;

        List<Integer> arr = new ArrayList<>();

        for(Map.Entry<Note, Integer> entry: notes.entrySet()) {
            int value = entry.getKey().getValue();
            int frequency = entry.getValue();
            for(int i = 0; i < frequency; i++) {
                arr.add(value);
            }
        }

        Collections.sort(arr);

        for (int k : arr) {
            for (int j = amount; j >= k; j--) {
                dp[j] = dp[j] || dp[j - k];
            }
        }

        return dp;
    }
}
