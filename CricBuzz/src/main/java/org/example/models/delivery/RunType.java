package org.example.models.delivery;

public enum RunType {
    WICKET(0),
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    SIX(6);

    private final int run;

    RunType(int run) {
        this.run = run;
    }

    public int getRun() {
        return run;
    }
}
