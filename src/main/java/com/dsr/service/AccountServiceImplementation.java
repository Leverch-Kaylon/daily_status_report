package com.dsr.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsr.dtos.ProjectDto;
import com.dsr.entity.Project;
import com.dsr.exceptionHandling.DataNotFound;
import com.dsr.mapping.MappingMapper;
import com.google.common.flogger.FluentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dsr.dtos.AccountDto;
import com.dsr.entity.Account;
import com.dsr.repositories.AccountRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	// Method used to create an account.
	@Override
	public AccountDto createAccount(Account account) {
		logger.atInfo().log("Service Layer : Creating account");
		account.setCreatedOn(Date.valueOf(LocalDate.now()));
		account.setModifiedOn(Date.valueOf(LocalDate.now()));
		return MappingMapper.INSTANCE.toAccountDTO(this.accountRepository.save(account));
	}

// Method used to update an account.
	@Override
	public Account updateAccount(int accountID,AccountDto accountdto) {
		logger.atInfo().log("Service Layer : Updating account");
		Account account = accountRepository.findById(accountID).orElseThrow(() -> new DataNotFound("Account with ID: "+accountID+" cannot be found"));
		account.setModifiedOn(Date.valueOf(LocalDate.now()));
		MappingMapper.INSTANCE.updateAccount(accountdto,account);
		this.accountRepository.save(account);
		return account;
	}

	// Method to retrieve all accounts.
	@Override
	public List<AccountDto> getAllAccounts() {
		logger.atInfo().log("Service Layer : Get all accounts");
		List<Account> allAccounts = accountRepository.findAll();
		List<AccountDto> dtoAccounts = new ArrayList<>();
		allAccounts.forEach(a -> dtoAccounts.add(MappingMapper.INSTANCE.toAccountDTO(a)));
	return dtoAccounts;
	}

	@Override
	public AccountDto findAccountOnID(int accountID){
		logger.atInfo().log("Service Layer : Get account by ID ", accountID);
		Account foundAccount = accountRepository.findById(accountID).orElseThrow(() -> new DataNotFound("Account with ID: "+accountID+" cannot be found"));
        return MappingMapper.INSTANCE.toAccountDTO(foundAccount);
	}

	@Override
	public Account findAccountOnIDReference(int accID) {
		logger.atInfo().log("Service Layer : Get account Reference by ID ", accID);
		AccountDto acc = new AccountDto();
		acc.setAccount_id(accID);
		return entityManager.getReference(Account.class, acc.getAccount_id());
	}

	// Method used to retrieve account dashboard details.
//	@Override
//	public List<AccountDto> getAccountsDashboard() {
//
//		return accountRepository.getAccountDashboard();
//	}

	@Override
	public List<Account> getAccountsFromManager(int reporting_manager) {
		logger.atInfo().log("Service Layer : Get accounts of manager with ID ", reporting_manager);
		return accountRepository.getAccountsFromManager(reporting_manager);

	}


}
