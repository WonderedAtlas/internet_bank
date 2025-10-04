package com.example.internet_bank.model;

import java.time.LocalDateTime;

public class OperationListDto {
    private LocalDateTime operationDate;
    private Integer operationType;
    private Long amount;

    public OperationListDto(LocalDateTime operationDate, Integer operationType, Long amount) {
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.amount = amount;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public OperationListDto setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
        return this;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public OperationListDto setOperationType(Integer operationType) {
        this.operationType = operationType;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public OperationListDto setAmount(Long amount) {
        this.amount = amount;
        return this;
    }
}