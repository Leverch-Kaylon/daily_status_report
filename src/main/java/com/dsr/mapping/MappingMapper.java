package com.dsr.mapping;


import com.dsr.dtos.AccountDto;
import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.ProjectDto;
import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import com.dsr.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MappingMapper {

    MappingMapper  INSTANCE = Mappers.getMapper(MappingMapper.class);

    @Mapping(target = "modified_by", ignore = true)
    @Mapping(target = "modified_on", ignore = true)
    @Mapping(target = "created_by", ignore = true)
    @Mapping(target = "created_on", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    EmployeeDto toDto(Employee appConfig);

    @Mapping(target = "modified_by", ignore = true)
    @Mapping(target = "modified_on", ignore = true)
    @Mapping(target = "created_by", ignore = true)
    @Mapping(target = "created_on", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    ProjectDto toProjectDTO(Project project);

    @Mapping(target = "modified_by", ignore = true)
    @Mapping(target = "modified_on", ignore = true)
    @Mapping(target = "created_by", ignore = true)
    @Mapping(target = "created_on", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "account_master",ignore = true)
    @Mapping(target = "reporting_manager",ignore = true)
    ProjectDto toProjectDTOUnderAccount(Project project);

    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    AccountDto toAccountDTO(Account account);
}
