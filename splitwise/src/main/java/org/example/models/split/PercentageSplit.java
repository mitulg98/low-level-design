package org.example.models.split;

import org.example.models.Split;
import org.example.models.User;

import java.util.List;

public class PercentageSplit extends Split {
    private List<Double> percentageDistribution;

    public PercentageSplit(User payer, List<User> consumers, Double amount, List<Double> percentageDistribution) {
        super(payer, consumers, amount);
        this.percentageDistribution = percentageDistribution;
    }

    public List<Double> getPercentageDistribution() {
        return percentageDistribution;
    }

    public void setPercentageDistribution(List<Double> percentageDistribution) {
        this.percentageDistribution = percentageDistribution;
    }
}
