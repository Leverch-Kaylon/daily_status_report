package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.mapping.MappingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.m3support.demo.dtos.AccountDto;
import com.m3support.demo.dtos.AccountIdDto;
import com.m3support.demo.dtos.ManagerDto;
import com.m3support.demo.entity.Account;
import com.m3support.demo.repositories.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	// Method used to create an account.
	@Override
	public ResponseEntity<AccountDto> createAccount(Account account) {

		return new ResponseEntity<AccountDto>(MappingMapper.INSTANCE.toAccountDTO(this.accountRepository.save(account)), HttpStatus.OK);

	}

//	// Method used to update an account.
//	@Override
//	public void updateAccount(Account account) {
//		this.accountRepository.save(account);
//	}

	// Method to retrieve all accounts.
//	@Override
//	public List<Account> getAllAccounts() {
//
//		return accountRepository.findAll();
//	}

	// Method used to retrieve account dashboard details.
//	@Override
//	public List<AccountDto> getAccountsDashboard() {
//
//		return accountRepository.getAccountDashboard();
//	}

	// Method used to retrieve account identifier details
//	@Override
//	public List<AccountIdDto> getAccountsForProjects() {
//
//		return accountRepository.getAccountsForProjects();
//	}

	// Method used to return all managers
//	@Override
//	public List<ManagerDto> getManagers() {
//
//		return accountRepository.getManagers();
//	}

//	@Override
//	public List<Account> getAccountsFromManager(int reporting_manager) {
//		return accountRepository.getAccountsFromManager(reporting_manager);
//
//	}


}
