package org.example.models.activity;

import org.example.interfaces.ActivityLogger;

public class Activity {
    private final ActivityType activityType;
    private final ActivityLogger activityLogger;

    public Activity(ActivityType activityType, ActivityLogger activityLogger) {
        this.activityType = activityType;
        this.activityLogger = activityLogger;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public ActivityLogger getActivityLogger() {
        return activityLogger;
    }

    public void logActivity() {
        activityLogger.logActivity();
    }
}
