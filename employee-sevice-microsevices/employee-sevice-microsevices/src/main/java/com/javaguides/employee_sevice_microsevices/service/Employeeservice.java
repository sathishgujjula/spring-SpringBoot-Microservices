package com.javaguides.employee_sevice_microsevices.service;

import com.javaguides.employee_sevice_microsevices.dto.ApiResponseDto;
import com.javaguides.employee_sevice_microsevices.dto.EmployeeDto;

public interface Employeeservice {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
 ApiResponseDto getEmployeeFirstName(Long employeeId);

}
