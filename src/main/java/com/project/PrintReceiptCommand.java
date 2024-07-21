package com.project;

public class PrintReceiptCommand implements Command {
    private final Receipt receipt;

    public PrintReceiptCommand(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public void execute() {
        receipt.printReceipt();
    }
}
