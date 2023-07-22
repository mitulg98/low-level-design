package org.example.models.match;

public enum MatchType {
    T20I(20, 4),
    ODI(50, 10);
    private final int totalOvers;
    private final int maxOversAllowedForBowler;
    MatchType(int totalOvers, int maxOversAllowedForBowler) {
        this.totalOvers = totalOvers;
        this.maxOversAllowedForBowler = maxOversAllowedForBowler;
    }

    public int getTotalOvers() {
        return totalOvers;
    }

    public int getMaxOversAllowedForBowler() {
        return maxOversAllowedForBowler;
    }
}
