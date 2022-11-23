package com.example.Try;

public class RoomBooking {
    String fullname;
    String phone;
    String email;
    String location;
    String flats;
    String room;

    public RoomBooking(String fullname, String phone, String email, String location, String flats, String room) {
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.flats = flats;
        this.room = room;
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

    public String getLocation() {
        return location;
    }

    public String getFlats() {
        return flats;
    }

    public String getRoom() {
        return room;
    }
}
