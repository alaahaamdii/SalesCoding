package com.project;

public class AddProductCommand implements Command {
    private final Receipt receipt;
    private final Product product;
    private final TaxCalculator taxCalculator;

    public AddProductCommand(Receipt receipt, Product product, TaxCalculator taxCalculator) {
        this.receipt = receipt;
        this.product = product;
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void execute() {
        double tax = taxCalculator.calculateTax(product);
        receipt.addProduct(product, tax);
    }
}
