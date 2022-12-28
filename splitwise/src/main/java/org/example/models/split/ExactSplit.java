package org.example.models.split;

import org.example.models.Split;
import org.example.models.User;

import java.util.List;

public class ExactSplit extends Split {
    public ExactSplit(User user, Double amount) {
        super(user);
        setAmount(amount);
    }
}
