package com.example.internet_bank;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OperationResult getBalance(Long user_id) {
        try {
            Optional<User> userOpt = userRepository.findById(user_id);
            if (userOpt.isPresent()) {
                return new OperationResult(userOpt.get().getBalance(), "");
            } else {
                return new OperationResult(-1, "Пользователь не найден");
            }
        } catch (Exception e) {
            return new OperationResult(-1, "Ошибка при выполнении операции");
        }
    }

    @Transactional
    public OperationResult putMoney(Long user_id, double amount) {

        if (amount <= 0) {
            return new OperationResult(0, "Некорректная сумма");
        }
        try {
            Optional<User> userOpt = userRepository.findById(user_id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                user.setBalance(user.getBalance() + amount);
                userRepository.save(user);
                return new OperationResult(1, "");
            } else {
                return new OperationResult(0, "Пользователь не найден");
            }
        } catch (Exception e) {
            return new OperationResult(0, "Ошибка при выполнении операции");
        }
    }

    @Transactional
    public OperationResult takeMoney(Long user_id, double amount) {
        if (amount <= 0) {
            return new OperationResult(0, "Некорректная сумма");
        }
        try {
            Optional<User> userOpt = userRepository.findById(user_id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                if (user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    userRepository.save(user);
                    return new OperationResult(1, "");
                } else {
                    return new OperationResult(0, "Недостаточно средств");
                }
            } else {
                return new OperationResult(0, "Пользователь не найден");
            }
        } catch (Exception e) {
            return new OperationResult(0, "Ошибка при выполнении операции");
        }
    }
}