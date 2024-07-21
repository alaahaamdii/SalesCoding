package com.project;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Product> products;
    private double totalSalesTax;
    private double totalPrice;

    public Receipt() {
        this.products = new ArrayList<>();
        this.totalSalesTax = 0;
        this.totalPrice = 0;
    }

    public void addProduct(Product product, double tax) {
        double finalPrice = (product.getPrice() + tax) * product.getQuantity();
        this.totalSalesTax += tax * product.getQuantity();
        this.totalPrice += finalPrice;
        this.products.add(new Product(product.getName(), finalPrice, product.isImported(), product.isExempt(), product.getQuantity()));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printReceipt() {
        for (Product product : products) {
            System.out.println(product.getQuantity() + " " +product.getName() + ": " + String.format("%.2f", product.getPrice()));
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", totalSalesTax));
        System.out.println("Total: " + String.format("%.2f", totalPrice));
    }
}
