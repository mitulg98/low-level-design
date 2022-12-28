package org.example.models.split;

import org.example.models.Split;
import org.example.models.User;

import java.util.List;

public class ExactSplit extends Split {
    private List<Double> distribution;

    public ExactSplit(User payer, List<User> consumers, Double amount, List<Double> distribution) {
        super(payer, consumers, amount);
        this.distribution = distribution;
    }

    public List<Double> getDistribution() {
        return distribution;
    }

    public void setDistribution(List<Double> distribution) {
        this.distribution = distribution;
    }
}
