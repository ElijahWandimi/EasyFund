package com.muendo.k_changa.model;

import androidx.annotation.NonNull;

public class Custodian{
    private String name;
    private String role;
    private String email;

    public Custodian(String name, String role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return "Custodian{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
