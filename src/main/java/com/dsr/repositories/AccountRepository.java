package com.dsr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsr.entity.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

//	@Query("SELECT new com.m3support.demo.dtos.AccountDto(a.account_id, a.account_desc, a.modifiedBy, "
//			+ "a.modifiedOn, a.createdBy, a.createdOn, a.deleted,"
//			+ " COUNT(p.account_master.account_id) as projects_count, e.emp_firstname, e.emp_id) "
//			+ "FROM Project p INNER JOIN p.account_master a INNER JOIN p.reporting_manager e "
//			+ "GROUP BY a.account_id ORDER BY a.modifiedOn DESC")
//	List<AccountDto> getAccountDashboard();
//
//	//@Query("SELECT new com.m3support.demo.dtos.AccountIdDto(a.account_id, a.account_desc) FROM Account a")
//	List<AccountIdDto> getAccountsForProjects();
//
//	//@Query("SELECT new com.m3support.demo.dtos.ManagerDto(emp.emp_id, emp.emp_psid, emp.emp_firstname) FROM Employee emp WHERE emp.emp_role like '%manager%' ")
//	List<ManagerDto> getManagers();
//
	@Query("SELECT DISTINCT proj.account_id from Project proj where proj.reporting_manager.emp_id = ?1")
    List<Account> getAccountsFromManager(int reporting_manager);
//
}
