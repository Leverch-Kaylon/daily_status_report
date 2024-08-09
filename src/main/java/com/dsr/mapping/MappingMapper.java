package com.dsr.mapping;


import com.dsr.dtos.AccountDto;
import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.ProjectDto;
import com.dsr.dtos.ReportDTO;
import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import com.dsr.entity.Project;
import com.dsr.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MappingMapper {

    MappingMapper  INSTANCE = Mappers.getMapper(MappingMapper.class);

    EmployeeDto toDto(Employee appConfig);

    ProjectDto toProjectDTO(Project project);

    ProjectDto toProjectDTOUnderAccount(Project project);

    AccountDto toAccountDTO(Account account);

    ReportDTO toReportDTO(Report report);
}
