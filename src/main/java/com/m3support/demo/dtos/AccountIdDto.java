package com.m3support.demo.dtos;

public class AccountIdDto {
	
    private int AccountId;
    private String AccountName;

    public AccountIdDto(int accountId, String accountName) {
        this.AccountId = accountId;
        this.AccountName = accountName;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        this.AccountName = accountName;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        this.AccountId = accountId;
    }
}
