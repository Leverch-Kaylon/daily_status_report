package com.m3support.demo.mapping;


import com.m3support.demo.dtos.AccountDto;
import com.m3support.demo.dtos.EmployeeDto;
import com.m3support.demo.dtos.ProjectDto;
import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Employee;
import com.m3support.demo.entity.Project;
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

    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    AccountDto toAccountDTO(Account account);
}
