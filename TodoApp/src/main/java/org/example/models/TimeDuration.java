package org.example.models;

import java.util.Date;

public class TimeDuration {
    private final Date startDate;
    private final Date endDate;

    public TimeDuration(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
