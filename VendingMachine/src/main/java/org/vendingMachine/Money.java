package org.vendingMachine;

import java.util.List;

public class Money {
    private final List<Note> notes;

    public Money(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public int getTotalAmount() {
        int amount = 0;

        for(Note note: notes) {
            amount += note.getValue();
        }

        return amount;
    }
}
