package com.x.schedule.application.models;

import java.util.Objects;

public class Engineer {
    private String name;
    private String phone;
    private Gender gender;

    public Engineer(String name, String phone, Gender gender) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return Objects.equals(name, engineer.name) &&
                Objects.equals(phone, engineer.phone) &&
                gender == engineer.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, gender);
    }
}
