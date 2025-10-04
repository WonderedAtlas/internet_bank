package com.example.internet_bank.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "operations", schema = "internet_bank")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operation_id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Integer operation_type;

    @Column(nullable = false)
    private Long amount;

    @Column(name = "operation_date", nullable = false)
    private LocalDateTime operationDate;

    public Long getOperation_id() {
        return operation_id;
    }

    public Operation setOperation_id(Long operation_id) {
        this.operation_id = operation_id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Operation setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOperation_type() {
        return operation_type;
    }

    public Operation setOperation_type(Integer operation_type) {
        this.operation_type = operation_type;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public Operation setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public Operation setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
        return this;
    }
}