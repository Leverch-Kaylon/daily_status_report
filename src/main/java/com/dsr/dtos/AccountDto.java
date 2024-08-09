package com.dsr.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class AccountDto {

    private int account_id;
    private String account_desc;


    // Account default constructor
    public AccountDto() {

    }

    public AccountDto(int account_id, String account_desc, boolean deleted, java.sql.Date created_on, String created_by,
                   java.sql.Date modified_on, String modified_by) {
        this.account_id = account_id;
        this.account_desc = account_desc;

    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_desc() {
        return account_desc;
    }

    public void setAccount_desc(String account_desc) {
        this.account_desc = account_desc;
    }

    @Override
    public String toString() {
        return "Account [account_id=" + account_id + ", account_desc=" + account_desc + "]";
    }

}
