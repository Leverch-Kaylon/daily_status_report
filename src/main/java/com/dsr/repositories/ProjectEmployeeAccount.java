package com.dsr.repositories;

import com.dsr.entity.AccountProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectEmployeeAccount extends JpaRepository<AccountProjectEmployee, Integer> {
}
