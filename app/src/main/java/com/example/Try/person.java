package com.example.Try;

// Your package name can be different depending
// on your project name


public class person
{
    // Variable to store data corresponding
    // to firstname keyword in database
    private String fullname;

    // Variable to store data corresponding
    // to lastname keyword in database
    private String phone;

    // Variable to store data corresponding
    // to age keyword in database


    // Mandatory empty constructor
    // for use of FirebaseUI
    private String type;
    private String county;

    public person() {}

    // Getter and setter method

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

//    public String getBudget_level()
//    {
//        return bu;
//    }
//    public void setBudget_level(String budget_level)
//    {
//        this.budget = ;
//    }
}

