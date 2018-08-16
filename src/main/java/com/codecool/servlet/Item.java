package com.codecool.servlet;

public class Item {
    //  a simple Java class with id (generated integer), name (string) and price (float or double) properties.
    private static int nextID = 1;
    private int id;
    private String name;
    private double price;

    Item(String name, double price) {
        id = nextID++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
