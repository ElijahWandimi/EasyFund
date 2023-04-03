package com.muendo.k_changa.repository;


public class ContributorDao{
    private String name;
    private int contributions;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    public void updateContributions(int contributions) {
        this.contributions += contributions;
    }
}
