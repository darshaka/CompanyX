package com.x.schedule.application.models;

import java.time.LocalDate;

public class Schedule {
    private Engineer engineer1;
    private Engineer engineer2;
    private LocalDate date;

    public Schedule(LocalDate date) {
        this.date = date;
    }

    public Engineer getEngineer1() {
        return engineer1;
    }

    public void setEngineer1(Engineer engineer1) {
        this.engineer1 = engineer1;
    }

    public Engineer getEngineer2() {
        return engineer2;
    }

    public void setEngineer2(Engineer engineer2) {
        this.engineer2 = engineer2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "engineer1=" + engineer1 +
                ", engineer2=" + engineer2 +
                ", date=" + date +
                '}';
    }
}
