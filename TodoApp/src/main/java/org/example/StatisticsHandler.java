package org.example;

import org.example.models.StatisticsType;

import java.util.*;

public class StatisticsHandler {
    private final TreeMap<Date, Map<StatisticsType, Integer>> statistics;

    public StatisticsHandler() {
        this.statistics = new TreeMap<>();
    }

    public void recordStatistics(StatisticsType statisticsType) {
        Date currentDate = new Date();
        statistics.putIfAbsent(currentDate, new EnumMap<>(StatisticsType.class));
        statistics.get(currentDate).putIfAbsent(statisticsType, 0);
        statistics.get(currentDate).put(statisticsType, statistics.get(currentDate).get(statisticsType) + 1);
    }

    public String getStatistics(Date startDate, Date endDate) {
        Map<Date, Map<StatisticsType, Integer>> statisticsInRange = statistics.subMap(startDate, true, endDate, true);
        EnumMap<StatisticsType, Integer> actualStats = new EnumMap<>(StatisticsType.class);
        statisticsInRange.values().forEach(statMap -> {
            statMap.keySet().forEach(key -> {
                actualStats.putIfAbsent(key, 0);
                actualStats.put(key, actualStats.get(key) + 1);
            });
        });

        return "Statistics for given duration :- ADDED TASKS - " + actualStats.get(StatisticsType.ADDITION) +
                " COMPLETED TASKS - " + actualStats.get(StatisticsType.COMPLETION) +
                " SPILLED OVER TASKS - " + actualStats.get(StatisticsType.SPILL_OVER);
    }
}
