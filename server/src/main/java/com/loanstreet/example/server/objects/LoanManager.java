package com.loanstreet.example.server.objects;
import java.sql.Array;
import java.util.*;

public class LoanManager {
    private Map<String, Loan> _loanmap = new HashMap<>();

    // check the file for loans we have
    public LoanManager() {

    }

    public String createLoan(double amount, double rate, double length, double payment) {
        Loan loan = new Loan(amount, rate, length, payment);
        _loanmap.put(loan.get_id(), loan);
        return loan.get_id();
    }

    public String getLoan(String loan_id) {
        Loan loan = _loanmap.get(loan_id);
        if (loan == null) {
            return "No loan with ID " + loan_id;
        }
        return loan.toString();
    }

    public List<String> getAllLoans() {
        List<String> loans = new ArrayList<>();
        for (Loan loan : _loanmap.values()) {
            loans.add(loan.toString());
        }
        return loans;
    }


    public String updateLoan(String loan_id, Map<String, Double> values) {
        Loan loan = _loanmap.get(loan_id);
        if (loan == null) {
            return "No loan with ID " + loan_id + "!";
        }
        StringBuilder builder = new StringBuilder("Loan update - \n");
        for (String key : values.keySet()) {
            switch(key) {
                case "amount":
                    loan._amount = values.get(key);
                    builder.append("Amount = ");
                    builder.append(loan._amount);
                    builder.append("\n");
                    break;
                case "rate":
                    loan._rate = values.get(key);
                    builder.append("Rate = ");
                    builder.append(loan._rate);
                    builder.append("\n");
                    break;
                case "length":
                    loan._length = values.get(key);
                    builder.append("Length = ");
                    builder.append(loan._length);
                    builder.append("\n");
                    break;
                case "payment":
                    loan._payment = values.get(key);
                    builder.append("Payment = ");
                    builder.append(loan._payment);
                    builder.append("\n");
                    break;
                default:
                    builder.append("No attribute ");
                    builder.append("\"");
                    builder.append(key);
                    builder.append("\"!\n");
            }
        }
        return builder.toString();
    }
}
