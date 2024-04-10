package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mapper.EmployeeMapper;
import com.helloworld.salaries.mapper.SalaryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Double> getSalaryByEmployyeCode(String codeempleado, int salaryyear) throws WrongParamsException {
        return employeeMapper.getSalaryByCodeEmpleadoAndYear(codeempleado, salaryyear);
    }

    @Override
    public List<Double> createSalariesByEmployeeCode(String codeempleado, int salaryyear) throws WrongParamsException {
        return employeeMapper.createSalariesByCodeEmpleado(codeempleado, salaryyear);
    }
}
