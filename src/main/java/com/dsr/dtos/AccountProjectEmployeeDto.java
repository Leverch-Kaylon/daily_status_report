package com.dsr.dtos;

import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import com.dsr.entity.Project;
import lombok.Data;


@Data
public class AccountProjectEmployeeDto {
    private Long account_id;
    private Long emp_id;
    private Long project_id;

}
