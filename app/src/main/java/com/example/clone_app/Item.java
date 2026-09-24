package com.example.clone_app;

public class Item {
    String name,email;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Item(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
