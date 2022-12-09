package controllers;

public class LowBalanceException extends Exception {
    public LowBalanceException() {
        super("Insufficient coinc balance to purchase item(s).");
    }
}