package com.example.thiti.project_application;


// This class use for store each object from Firebasedatabase.
public class User {

    public String username, firstname, lastname, school, age, phone;

    public User() {

    }

    public User(String username, String firstname, String lastname, String school, String age, String phone) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.school = school;
        this.age = age;
        this.phone = phone;
    }
}
