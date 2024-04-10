package com.helloworld.salaries.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SalaryMapper {

    @Select("SELECT AVG(TotalAnnualSalary) AS AverageAnnualSalary " +
            "FROM ( " +
            "SELECT CODEMPLEADO, SUM(SALARY) AS TotalAnnualSalary " +
            "FROM salary " +
            "WHERE SALARYYEAR = #{year} " +
            "GROUP BY CODEMPLEADO) AS AnnualSalaries")
    public double getAvgSalary(int year);




}
