package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.dtos.AccountDto;
import com.m3support.demo.dtos.AccountIdDto;
import com.m3support.demo.dtos.ManagerDto;
import com.m3support.demo.entity.Account;
import org.springframework.http.ResponseEntity;

public interface AccountService {

	ResponseEntity<AccountDto> createAccount(Account account);
//
//	List<Account> getAllAccounts();
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
