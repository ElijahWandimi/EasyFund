package com.muendo.k_changa.model;


public class Contributor {
    private String name;
    private int contributions;

    public Contributor(String name, int contributions) {
        this.name = name;
        this.contributions = contributions;
    }

    public Contributor() {
    }

    public String getName() {
        return name;
    }
    public int getContributions() {
        return contributions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }
}
