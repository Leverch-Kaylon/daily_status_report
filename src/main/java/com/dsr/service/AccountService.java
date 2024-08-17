package com.dsr.service;

import java.util.List;

import com.dsr.dtos.AccountDto;
import com.dsr.entity.Account;
import org.springframework.http.ResponseEntity;

public interface AccountService {

	AccountDto createAccount(Account account);
//
	List<AccountDto> getAllAccounts();
	public AccountDto findAccountOnID(int projID);

	public Account findAccountOnIDReference(int projID);

	Account updateAccount(int accountID,AccountDto account);

//	List<AccountDto> getAccountsDashboard();

	List<Account> getAccountsFromManager(int reporting_manager);


}
