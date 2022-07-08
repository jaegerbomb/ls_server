package com.loanstreet.example.server.objects;

import java.util.UUID;

// Loan class - holds data about each loan
public class Loan extends Object {
    private String _id = UUID.randomUUID().toString();
    public double _amount = 0;         // dollars
    public double _rate = 0;  // (0 - 1.0)
    public double _length = 0;         // months
    public double _payment = 0;        // dollars per month

    public String get_id() {
        return this._id;
    }

    @Override
    public String toString() {
        return "id:" + _id + ",amount:" + _amount + ",rate:" + _rate + ",length:" + _length + ",payment:" + _payment;
    }


    public Loan(double amount, double rate, double length, double payment) {
        this._amount = amount;
        this._rate = rate;
        this._length = length;
        this._payment = payment;
    }
}
