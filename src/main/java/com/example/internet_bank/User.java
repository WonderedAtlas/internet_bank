package com.example.internet_bank;

import jakarta.persistence.*;

@Entity
@Table(name = "user_balance", schema = "internet_bank")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private double balance; // баланс пользователя

    // геттеры и сеттеры
    public Long getId() { return user_id; }
    public void setId(Long user_id) { this.user_id = user_id; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
