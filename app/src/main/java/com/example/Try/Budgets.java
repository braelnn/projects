package com.example.Try;

public class Budgets {

    String people;
    String budget;
    String county;
    String type;

    public Budgets(String people, String budget, String county, String type) {
        this.people = people;
        this.budget = budget;
        this.county = county;
        this.type = type;
    }

    public String getPeople() {
        return people;
    }

    public String getBudget() {
        return budget;
    }

    public String getCounty() {
        return county;
    }

    public String getType() {
        return type;
    }
}
