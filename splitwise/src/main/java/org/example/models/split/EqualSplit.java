package org.example.models.split;

import org.example.models.Split;
import org.example.models.User;

import java.util.List;

public class EqualSplit extends Split {
    public EqualSplit(User payer, List<User> consumers, Double amount) {
        super(payer, consumers, amount);
    }
}
