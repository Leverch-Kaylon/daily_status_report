package com.dsr.service;

import java.util.List;

import com.dsr.dtos.AccountDto;
import com.dsr.entity.Account;
import org.springframework.http.ResponseEntity;

public interface AccountService {

	ResponseEntity<AccountDto> createAccount(Account account);
//
	ResponseEntity<List<AccountDto>> getAllAccounts();
	public Account findAccountOnID(int projID);
//
//	void updateAccount(Account account);
//
//	List<AccountDto> getAccountsDashboard();
//
//	List<AccountIdDto> getAccountsForProjects();
//
//	List<ManagerDto> getManagers();
//
//	List<Account> getAccountsFromManager(int reporting_manager);


}
