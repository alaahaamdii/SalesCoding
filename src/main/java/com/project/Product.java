package com.project;

public class Product {
    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isExempt;
    private final int quantity;

    public Product(String name, double price, boolean isImported, boolean isExempt, int quantity) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
        this.quantity = quantity;

    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public boolean isImported() { return isImported; }
    public boolean isExempt() { return isExempt; }
}

