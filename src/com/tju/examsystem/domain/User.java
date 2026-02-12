package com.tju.examsystem.domain;

import java.util.Objects;


public class User {
    private String username;
    private Integer permission;

    public User() {
    }

    public User(String username, Integer permission) {
        this.username = username;
        this.permission = permission;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPermission(), user.getPermission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPermission());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", permission=" + permission +
                '}';
    }
}
