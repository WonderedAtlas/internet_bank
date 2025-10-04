package com.example.internet_bank.model;



public class OperationResultDto {
    private double value;
    private String reason;

    public OperationResultDto(double value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    public double getValue() {
        return value;
    }

    public OperationResultDto setValue(double value) {
        this.value = value;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public OperationResultDto setReason(String reason) {
        this.reason = reason;
        return this;
    }
}