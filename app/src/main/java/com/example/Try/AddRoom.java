package com.example.Try;

public class AddRoom {
    String location;
    String apartments;
    String roomnumber;

    public AddRoom(String location, String apartments, String roomnumber) {
        this.location = location;
        this.apartments = apartments;
        this.roomnumber = roomnumber;
    }

    public String getLocation() {
        return location;
    }

    public String getApartments() {
        return apartments;
    }

    public String getRoomnumber() {
        return roomnumber;
    }
}
