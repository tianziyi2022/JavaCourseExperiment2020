package com.tianziyi.project02;

import java.util.ArrayList;

class Account {

    private String userId;
    private String userName;
    private Long createTime;
    private String idCard;
    private Double sum;
    private ArrayList<String> record;

    public Account addAccount(String userId, String userName, String idCard) {
        Account account = new Account();
        account.userId = userId;
        account.userName = userName;
        account.idCard = idCard;
        account.sum = 0.0;
        account.createTime = System.currentTimeMillis();
        account.record.add("new account at " + System.currentTimeMillis());
        return account;
    }

    public void deposit(Double in) {
        this.sum += in;
        this.record.add("desposit " + in + "at" + System.currentTimeMillis());
    }

    public void draw(Double out) {
        this.sum -= out;
        this.record.add("draw at " + out + "at" + System.currentTimeMillis());
    }

    public Double inquiryAccount() {
        return this.sum;
    }

    public ArrayList<String> inquiryRecord() {
        return this.record;
    }

    public void logoff() {
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

class Person{
    private String name;
    private String idCard;
    private Account account;

    public Person(String name, String idCard, Account account) {
        this.name = name;
        this.idCard = idCard;
        this.account = account;
    }

    public Account addAccount(String userId, String userName, String idCard) {
        this.account.addAccount(userId, userName, idCard);
        return this.account;
    }
    public void deposit(Double in) {
        this.account.deposit(in);
    }
    public void draw(Double out) {
        this.account.draw(out);
    }
    public Double inquiryAccount() {
        return this.account.inquiryAccount();
    }
    public ArrayList<String> inquiryRecord() {
        return this.account.inquiryRecord();
    }
    public void logoff() {
        this.account.logoff();
    }
}

class Student extends Person{
    private String number;
    private String date;
    private Double score;

    public Student(String name, String idCard, Account account) {
        super(name, idCard, account);
    }
}

public class Ex02 {
}
