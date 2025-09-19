package com.example.internet_bank;



public class OperationResult {
    private double value;
    private String reason;

    public OperationResult(double value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    public double getValue() {
        return value;
    }

    public OperationResult setValue(double value) {
        this.value = value;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public OperationResult setReason(String reason) {
        this.reason = reason;
        return this;
    }
}