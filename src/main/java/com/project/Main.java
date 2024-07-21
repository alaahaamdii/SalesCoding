package com.project;

// Main.java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("2 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85");
        List<String> input2 = Arrays.asList("1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50");
        List<String> input3 = Arrays.asList("1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75", "1 box of imported chocolates at 11.25");

        processInputAndPrintReceipt(input1);
        processInputAndPrintReceipt(input2);
        processInputAndPrintReceipt(input3);
    }

    private static void processInputAndPrintReceipt(List<String> input) {
        TaxCalculator taxCalculator = new BasicTaxCalculator();
        Receipt receipt = new Receipt();
        CommandInvoker invoker = new CommandInvoker();

        for (String line : input) {
            Command addProductCommand = getCommand(line, receipt, taxCalculator);
            invoker.addCommand(addProductCommand);
        }

        Command printReceiptCommand = new PrintReceiptCommand(receipt);
        invoker.addCommand(printReceiptCommand);

        invoker.executeCommands();
    }

    private static Command getCommand(String line, Receipt receipt, TaxCalculator taxCalculator) {
        String[] parts = line.split(" at ");
        double price = Double.parseDouble(parts[1]);
        String[] details = parts[0].split(" ", 2);
        int quantity = Integer.parseInt(details[0]);
        String name = details[1];

        boolean isImported = name.contains("imported");
        boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pill");

        Product product = new Product(name, price, isImported, isExempt,quantity);
        return new AddProductCommand(receipt, product, taxCalculator);
    }
}
