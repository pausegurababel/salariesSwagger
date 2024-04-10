package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;

import java.util.List;

public interface EmployeeService {


    List<Double> getSalaryByEmployyeCode(String codeempleado, int salaryyear) throws WrongParamsException;

    List<Double> createSalariesByEmployeeCode(String codeempleado, int salaryyear) throws WrongParamsException;
}
