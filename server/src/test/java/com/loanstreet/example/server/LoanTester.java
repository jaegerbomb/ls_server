package com.loanstreet.example.server;
import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import com.loanstreet.example.server.objects.LoanManager;

public class LoanTester {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        LoanManager manager = new LoanManager();
        Random r = new Random();
        List<String> loan_ids = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            double amount = r.nextDouble();
            double length = r.nextDouble();
            double rate = r.nextDouble();
            double payment = r.nextDouble();
            String l_id = manager.createLoan(amount, length, rate, payment);
            loan_ids.add(l_id);
            System.out.println(l_id);
        }

        // test the loans
        Map<String, Double> l_info = new HashMap<>();
        for (String loan_id : loan_ids) {
            l_info.put("amount", r.nextDouble());
            l_info.put("rate", r.nextDouble());
            l_info.put("nothing", r.nextDouble());
            System.out.println(manager.updateLoan(loan_id, l_info));
        }

        // get all loans
        List<String> loans = manager.getAllLoans();
        System.out.println(loans.stream().map(Object::toString).collect(Collectors.joining("\n")).toString());
    }
}
