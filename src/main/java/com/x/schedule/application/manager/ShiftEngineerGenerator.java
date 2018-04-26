package com.x.schedule.application.manager;

import com.x.schedule.application.models.Engineer;
import com.x.schedule.application.models.Gender;

import java.util.ArrayList;
import java.util.List;

public class ShiftEngineerGenerator {

    public List<Engineer> genarate(int requiredEnginerShifts, int availableEngineer) {
        List<Engineer> availableEngList = getAvailableEnginners(availableEngineer);
        List<Engineer> shiftEngineerList = new ArrayList<>();

        for (Engineer engineer : availableEngList) {
            shiftEngineerList.add(engineer);
            shiftEngineerList.add(engineer);
        }

        while (shiftEngineerList.size() < requiredEnginerShifts) {
            shiftEngineerList.add(Utils.getRandomEnginner(availableEngList));
        }

        return shiftEngineerList;

    }

    private List<Engineer> getAvailableEnginners(int availableEngineers) {
        List<Engineer> engineers = new ArrayList<>();
        for (int x = 0; x < availableEngineers; x++) {
            engineers.add(new Engineer("name " + x, "+6000000"+x, Gender.MALE));
        }
        return engineers;
    }

}
