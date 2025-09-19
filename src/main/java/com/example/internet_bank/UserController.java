package com.example.internet_bank;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getBalance/{user_id}")
    public OperationResult getBalance(@PathVariable Long user_id) {
        return userService.getBalance(user_id);
    }

    @PostMapping("/putMoney/{user_id}")
    public OperationResult putMoney(@PathVariable Long user_id, @RequestParam double amount) {
        return userService.putMoney(user_id, amount);
    }

    @PostMapping("/takeMoney/{user_id}")
    public OperationResult takeMoney(@PathVariable Long user_id, @RequestParam double amount) {
        return userService.takeMoney(user_id, amount);
    }

}