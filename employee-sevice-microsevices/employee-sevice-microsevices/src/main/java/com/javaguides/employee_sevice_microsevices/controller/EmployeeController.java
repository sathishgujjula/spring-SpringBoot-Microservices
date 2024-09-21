package com.javaguides.employee_sevice_microsevices.controller;

import com.javaguides.employee_sevice_microsevices.dto.ApiResponseDto;
import com.javaguides.employee_sevice_microsevices.dto.EmployeeDto;
import com.javaguides.employee_sevice_microsevices.service.Employeeservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private Employeeservice employeeservice;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeservice.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeIdd(@PathVariable("id") Long employeeId) {
        System.out.println("hello");
        ApiResponseDto ApiResponseDto = employeeservice.getEmployeeFirstName(employeeId);
        System.out.println("api controller");
        return new ResponseEntity<>(ApiResponseDto, HttpStatus.OK);
    }

}
