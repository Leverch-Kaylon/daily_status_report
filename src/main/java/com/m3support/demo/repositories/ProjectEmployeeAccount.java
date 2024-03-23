package com.m3support.demo.repositories;

import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.AccountProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectEmployeeAccount extends JpaRepository<AccountProjectEmployee, Integer> {
}
