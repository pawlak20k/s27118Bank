package org.example;

public class ResponseTransaction {
    private StatusTransaction status;
    private double newBalance;

    public ResponseTransaction() {
    }

    public ResponseTransaction(StatusTransaction statusTransaction, double balance) {
        this.status = statusTransaction;
        this.newBalance = balance;
    }

    public StatusTransaction getStatus() {
        return status;
    }

    public double getNewBalance() {
        return newBalance;
    }
}
