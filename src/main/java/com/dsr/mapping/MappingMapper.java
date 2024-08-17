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
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MappingMapper {

    MappingMapper  INSTANCE = Mappers.getMapper(MappingMapper.class);

    EmployeeDto toDto(Employee appConfig);

    ProjectDto toProjectDTO(Project project);

    @Mapping(target= "modified_by", ignore = true)
    AccountDto toAccountDTO(Account account);

    ReportDTO toReportDTO(Report report);

    @Mapping(target= "account_id", ignore = true)
    void updateAccount(AccountDto accountDto, @MappingTarget Account account );

    @Mapping(target= "project_id", ignore = true)
    void updateProject(ProjectDto projectDto, @MappingTarget Project project );
}
