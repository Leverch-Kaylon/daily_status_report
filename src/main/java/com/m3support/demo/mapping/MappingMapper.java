package com.m3support.demo.mapping;


import com.m3support.demo.dtos.EmployeeDto;
import com.m3support.demo.entity.Employee;
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
}
