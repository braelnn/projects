package com.example.Try;

public class Destinations {
    String fullname;
    String phone;
    String email;
    String county;
    String type;

    String budget_level;
    String gender;
    String No_of_adult;
    String No_of_children;

    public Destinations(String fullname, String phone, String type, String email, String county, String budget_level, String gender, String no_of_adult, String no_of_children) {
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.county = county;
        this.type = type;

        this.budget_level = budget_level;
        this.gender = gender;
        No_of_adult = no_of_adult;
        No_of_children = no_of_children;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCounty() {
        return county;
    }

    public String getType() {
        return type;
    }


    public String getBudget_level() {
        return budget_level;
    }

    public String getGender() {
        return gender;
    }

    public String getNo_of_adult() {
        return No_of_adult;
    }

    public String getNo_of_children() {
        return No_of_children;
    }
}
