package com.javaguides.employee_sevice_microsevices.repository;

import com.javaguides.employee_sevice_microsevices.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
