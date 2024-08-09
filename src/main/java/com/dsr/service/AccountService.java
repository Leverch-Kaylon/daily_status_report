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

	//
//	void updateAccount(Account account);
//
//	List<AccountDto> getAccountsDashboard();
//
//	List<AccountIdDto> getAccountsForProjects();

	List<Account> getAccountsFromManager(int reporting_manager);


}
