package com.javaguides.Department_sevice_microsevices.repository;

import com.javaguides.Department_sevice_microsevices.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Deparment, Long> {

    Deparment findByDepartmentCode(String departmentCode);
}
