package com.javaguides.Department_sevice_microsevices.service;

import com.javaguides.Department_sevice_microsevices.dto.DepartmentDto;

public interface DeartmentService {

    DepartmentDto saveDepatmentService(DepartmentDto departmentDto);

    DepartmentDto getDeparmentByCode(String code);
}
