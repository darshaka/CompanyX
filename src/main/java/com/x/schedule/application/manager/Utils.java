package com.x.schedule.application.manager;

import com.x.schedule.application.models.Engineer;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Utils {

    public static Engineer getRandomEnginner(Collection engineers) {
        Random rnd = new Random();
        int i = rnd.nextInt(engineers.size());
        return (Engineer) engineers.toArray()[i];
    }

    public static Engineer getRandomEngineerAndRemoveFromList(List<Engineer> engineers) {
        Random rnd = new Random();
        int i = rnd.nextInt(engineers.size());
        Engineer engineer = engineers.get(i);
        engineers.remove(i);
        return engineer;
    }

    public static void addEngineerToList(List<Engineer> engineers, Engineer engineer) {
        engineers.add(engineer);
    }

}
