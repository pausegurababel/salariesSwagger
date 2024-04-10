package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.AvgSalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mapper.SalaryMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class AvgSalaryServiceImpl implements AvgSalaryService {

        private final int minimalYear = 2000;

        private final SalaryMapper salaryMapper;

    public AvgSalaryServiceImpl(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }


    @Override
        public double getAvgSalary(int year) throws WrongParamsException {
            return salaryMapper.getAvgSalary(year);
        }

        private void validateYear(int year) throws WrongParamsException {
            if (year < this.minimalYear || year > LocalDate.now().getYear()) {
                throw new WrongParamsException("year");
            }
        }


}
