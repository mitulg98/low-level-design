package org.example.models.delivery;

public class Delivery {
    private final BallType ballType;
    private final RunType runType;

    public Delivery(BallType ballType, RunType runType) {
        this.ballType = ballType;
        this.runType = runType;
    }

    public BallType getBallType() {
        return ballType;
    }

    public RunType getRunType() {
        return runType;
    }
}
