package org.example;

import org.example.models.activity.Activity;

import java.util.*;

public class ActivityAuditor {
    private final TreeMap<Date, List<Activity>> activityAudit;

    public ActivityAuditor() {
        this.activityAudit = new TreeMap<>();
    }

    public void addActivity(Activity activity) {
        Date currentDate = new Date();
        activityAudit.putIfAbsent(currentDate, new ArrayList<>());
        activityAudit.get(currentDate).add(activity);
    }

    public List<Activity> getActivities(Date startDate, Date endDate) {
        Map<Date, List<Activity>> activitiesInRange = activityAudit.subMap(startDate, true, endDate, true);
        List<Activity> activities = new ArrayList<>();
        activitiesInRange.values().forEach(activities::addAll);
        return activities;
    }
}
