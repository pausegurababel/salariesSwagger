package com.helloworld.salaries.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT salary FROM SALARY WHERE SALARYYEAR = #{year} AND CODEMPLEADO = #{employeecode}")
    public List<Double> getSalaryByCodeEmpleadoAndYear(String employeecode, int year);

    public List<Double> createSalariesByCodeEmpleado(String employeecode, int year);
}
