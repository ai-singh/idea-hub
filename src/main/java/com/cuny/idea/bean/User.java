package com.cuny.idea.bean;

public class User {
    private String username;
    private String password;
    private int cunyId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCunyId() {
        return cunyId;
    }

    public void setCunyId(int cunyId) {
        this.cunyId = cunyId;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, username=%s]", cunyId, username);
    }
}
