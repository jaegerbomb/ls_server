package com.loanstreet.example.server.controller;

import com.loanstreet.example.server.objects.LoanManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServerController {
    public static LoanManager manager = new LoanManager();
    @GetMapping("health")
    public String test_me() {
        return "up";
    }

    @PostMapping("create")
    public String create_loan(@RequestParam("amount") double amount, @RequestParam("rate") double rate,
                              @RequestParam("length") double length, @RequestParam("payment") double payment)
    {
        String id = manager.createLoan(amount, rate, length, payment);
        return id;
    }

    @GetMapping("get")
    public String get_loan(@RequestParam("id") String id) {
        return manager.getLoan(id);
    }

    @GetMapping("all")
    public List<String> get_all_loans() { return manager.getAllLoans(); }

    @PostMapping("update")
    public String update_loan(@RequestParam("id") String id, @RequestParam("amount")Optional<Double> amount,
                              @RequestParam("rate") Optional<Double> rate, @RequestParam("length") Optional<Double> length,
                              @RequestParam("payment") Optional<Double> payment)
    {
        Map<String, Double> option_map = new HashMap<>();
        amount.ifPresent(aDouble -> option_map.put("amount", aDouble));
        rate.ifPresent(aDouble -> option_map.put("rate", aDouble));
        length.ifPresent(aDouble -> option_map.put("length", aDouble));
        payment.ifPresent(aDouble -> option_map.put("payment", aDouble));
        return manager.updateLoan(id, option_map);
    }


}
