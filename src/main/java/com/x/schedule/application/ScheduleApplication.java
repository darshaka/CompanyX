package com.x.schedule.application;

import com.x.schedule.application.manager.ShiftEngineerGenerator;
import com.x.schedule.application.manager.ShiftGenerator;
import com.x.schedule.application.manager.Utils;
import com.x.schedule.application.models.Engineer;
import com.x.schedule.application.models.Schedule;
import com.x.schedule.application.util.Constant;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleApplication {
    public static void main(String[] args) {

        LocalDate start = LocalDate.parse("2018-04-26");
        LocalDate end = start.plusDays(Constant.TWO_WEEKS);

        List<Schedule> scheduleList= ShiftGenerator.genarateDefault(start, end);

        List<Engineer> shiftEngineerList = new ShiftEngineerGenerator().genarate((scheduleList.size() * 2), 10);

        boolean retry = true;

        while(retry) {
            retry = makeSchedule(scheduleList.stream().collect(Collectors.toList()), shiftEngineerList.stream().collect(Collectors.toList()));
        }

        printSchedule(scheduleList);

    }


    private static boolean makeSchedule(List<Schedule> scheduleList, List<Engineer> shiftEngineerList) {
        Engineer engineer1 = null;
        Engineer engineer2 = null;

        for (int x = 0; x < scheduleList.size(); x++) {
            engineer1 = Utils.getRandomEngineerAndRemoveFromList(shiftEngineerList);
            engineer2 = Utils.getRandomEngineerAndRemoveFromList(shiftEngineerList);
            if(x == 0) {
                while (engineer1.equals(engineer2)) {
                    Utils.addEngineerToList(shiftEngineerList, engineer2);
                    engineer2 = Utils.getRandomEngineerAndRemoveFromList(shiftEngineerList);
                }
            } else if(x == (scheduleList.size() -1)) {
                if(engineer1.equals(scheduleList.get(x-1).getEngineer1()) || engineer1.equals(scheduleList.get(x-1).getEngineer2())) {
                    return true;
                }
                else if (engineer2.equals(scheduleList.get(x-1).getEngineer1()) || engineer2.equals(scheduleList.get(x-1).getEngineer2())) {
                    return true;
                }
            }
            else {
                while (engineer1.equals(engineer2)) {
                    Utils.addEngineerToList(shiftEngineerList, engineer2);
                    engineer2 = Utils.getRandomEngineerAndRemoveFromList(shiftEngineerList);
                }
                while(engineer1.equals(scheduleList.get(x-1).getEngineer1()) || engineer1.equals(scheduleList.get(x-1).getEngineer2())) {
                    Utils.addEngineerToList(shiftEngineerList, engineer1);
                    engineer1 = Utils.getRandomEngineerAndRemoveFromList(shiftEngineerList);
                }
                while(engineer2.equals(scheduleList.get(x-1).getEngineer1()) || engineer2.equals(scheduleList.get(x-1).getEngineer2())) {
                    Utils.addEngineerToList(shiftEngineerList, engineer2);
                    engineer2 = Utils.getRandomEngineerAndRemoveFromList(shiftEngineerList);
                }

            }
            Schedule schedule = scheduleList.get(x);
            schedule.setEngineer1(engineer1);
            schedule.setEngineer2(engineer2);
            scheduleList.set(x, schedule);
        }
        return false;
    }

    private static void printSchedule(List<Schedule> schedules) {
        for (Schedule schedule :
                schedules) {
            System.out.println(schedule.getDate() + " : " + schedule.getEngineer1().getName() + " & " + schedule.getEngineer2().getName());
        }
    }

}
