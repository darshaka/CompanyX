package com.x.schedule.application.manager;

import com.x.schedule.application.models.Schedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShiftGenerator {

    public static List<Schedule> genarateDefault(LocalDate startDate, LocalDate endDate) {
        List<Schedule> schedules = new ArrayList<>();
        LocalDate next = startDate.minusDays(1);
        while ((next = next.plusDays(1)).isBefore(endDate.plusDays(1))) {
            schedules.add(new Schedule(next));
        }
        return schedules;
    }
}
