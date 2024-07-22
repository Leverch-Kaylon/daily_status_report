package com.dsr.service;

import java.util.ArrayList;
import java.util.List;

import com.dsr.mapping.MappingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dsr.dtos.AccountDto;
import com.dsr.entity.Account;
import com.dsr.repositories.AccountRepository;

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
	@Override
	public ResponseEntity<List<AccountDto>> getAllAccounts() {

		List<AccountDto> dtoAccounts = new ArrayList<>();
		for(Account accounts :accountRepository.findAll()){
			dtoAccounts.add(MappingMapper.INSTANCE.toAccountDTO(accounts));
		}

	return new ResponseEntity<List<AccountDto>>(dtoAccounts,HttpStatus.OK);
	}

	public Account findAccountOnID(int projID){
		return accountRepository.findById(projID).get();
	}

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
