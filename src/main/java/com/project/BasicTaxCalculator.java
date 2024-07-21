package com.project;

public class BasicTaxCalculator implements TaxCalculator {
    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    @Override
    public double calculateTax(Product product) {
        double tax = 0;
        if (!product.isExempt()) {
            tax += roundTax(product.getPrice() * BASIC_TAX_RATE);
        }
        if (product.isImported()) {
            tax += roundTax(product.getPrice() * IMPORT_TAX_RATE);
        }
        return tax;
    }

    public double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
    }
}
