package com.example.internet_bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_balance", schema = "internet_bank")

public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Long balance;

    public Long getId() {
        return userId;
    }

    public void setId(Long user_id) {
        this.userId = user_id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
