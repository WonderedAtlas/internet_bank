package com.example.internet_bank.service;

import com.example.internet_bank.entity.Operation;
import com.example.internet_bank.entity.User;
import com.example.internet_bank.model.OperationListDto;
import com.example.internet_bank.model.OperationResultDto;
import com.example.internet_bank.repository.OperationRepository;
import com.example.internet_bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final int OPERATION_TYPE_PUT_MONEY = 1;
    private static final int OPERATION_TYPE_TAKE_MONEY = 2;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OperationRepository operationRepository;

    public UserService(UserRepository userRepository, OperationRepository operationRepository) {
        this.userRepository = userRepository;
        this.operationRepository = operationRepository;
    }

    public OperationResultDto getBalance(Long userId) {
        try {
            Optional<User> userOpt = userRepository.findById(userId);
            if (userOpt.isPresent()) {
                return new OperationResultDto(userOpt.get().getBalance(), "");
            } else {
                return new OperationResultDto(-1, "Пользователь не найден");
            }
        } catch (Exception e) {
            return new OperationResultDto(-1, "Ошибка при выполнении операции" + " " + e.getMessage());
        }
    }

    @Transactional
    public OperationResultDto putMoney(Long userId, Long amount) {

        if (amount <= 0) {
            return new OperationResultDto(0, "Некорректная сумма");
        }
        try {
            Optional<User> userOpt = userRepository.findById(userId);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                user.setBalance(user.getBalance() + amount);
                userRepository.save(user);
                saveOperation(userId, OPERATION_TYPE_PUT_MONEY, amount);
                return new OperationResultDto(1, "");
            } else {
                return new OperationResultDto(0, "Пользователь не найден");
            }
        } catch (Exception e) {
            return new OperationResultDto(0, "Ошибка при выполнении операции" + " " + e.getMessage());
        }
    }

    @Transactional
    public OperationResultDto takeMoney(Long userId, Long amount) {
        if (amount <= 0) {
            return new OperationResultDto(0, "Некорректная сумма");
        }
        try {
            Optional<User> userOpt = userRepository.findById(userId);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                if (user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    userRepository.save(user);
                    saveOperation(userId, OPERATION_TYPE_TAKE_MONEY, amount);
                    return new OperationResultDto(1, "");
                } else {
                    return new OperationResultDto(0, "Недостаточно средств");
                }
            } else {
                return new OperationResultDto(0, "Пользователь не найден");
            }
        } catch (Exception e) {
            return new OperationResultDto(0, "Ошибка при выполнении операции" + e.getMessage());
        }
    }

    private void saveOperation(Long userId, int operationType, Long amount) {
        Operation op = new Operation();
        op.setUserId(userId);
        op.setOperation_type(operationType);
        op.setAmount(amount);
        op.setOperationDate(LocalDateTime.now());
        operationRepository.save(op);
    }

    public List<OperationListDto> getOperationList(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Operation> operations;

        if (startDate == null && endDate == null) {
            // Возвращаем все операции пользователя без фильтрации по дате
            operations = operationRepository.findByUserId(userId);

        } else {
            // Фильтрация по диапазону дат
            operations = operationRepository.findByUserIdAndOperationDateBetween(userId, startDate, endDate);
        }
        return operations.stream()
                .map(op -> new OperationListDto(op.getOperationDate(), op.getOperation_type(), op.getAmount()))
                .collect(Collectors.toList());
    }

}