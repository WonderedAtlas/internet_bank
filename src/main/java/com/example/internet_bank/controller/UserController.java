package com.example.internet_bank.controller;

import com.example.internet_bank.model.OperationResultDto;
import com.example.internet_bank.service.UserService;
import com.example.internet_bank.model.OperationListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getBalance/{userId}")
    public OperationResultDto getBalance(@PathVariable Long userId) {
        return userService.getBalance(userId);
    }

    @GetMapping("/getOperationList/{userId}")
    public ResponseEntity<List<OperationListDto>> getOperations(
            @PathVariable Long userId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        List<OperationListDto> operations = userService.getOperationList(userId, startDate, endDate);
        return ResponseEntity.ok(operations);
    }

    @PostMapping("/putMoney/{userId}")
    public OperationResultDto putMoney(@PathVariable Long userId, @RequestParam Long amount) {
        return userService.putMoney(userId, amount);
    }

    @PostMapping("/takeMoney/{userId}")
    public OperationResultDto takeMoney(@PathVariable Long userId, @RequestParam Long amount) {
        return userService.takeMoney(userId, amount);
    }


}