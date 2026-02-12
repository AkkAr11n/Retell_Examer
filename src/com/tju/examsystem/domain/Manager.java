package com.tju.examsystem.domain;

import java.util.Objects;


public class Manager {
    private String managerId;
    private String name;

    public Manager() {
    }

    public Manager(String managerId, String name) {
        this.managerId = managerId;
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager manager)) return false;
        return Objects.equals(getManagerId(), manager.getManagerId()) && Objects.equals(getName(), manager.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManagerId(), getName());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
