package com.javaguides.Department_sevice_microsevices.service.impl;

import com.javaguides.Department_sevice_microsevices.dto.DepartmentDto;
import com.javaguides.Department_sevice_microsevices.entity.Deparment;
import com.javaguides.Department_sevice_microsevices.repository.DepartmentRepository;
import com.javaguides.Department_sevice_microsevices.service.DeartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl  implements DeartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepatmentService(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity

        Deparment department = new Deparment(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Deparment savedDapertment =  departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDapertment.getId(),
                savedDapertment.getDepartmentName(),
                savedDapertment.getDepartmentDescription(),
                savedDapertment.getDepartmentCode()
        );

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDeparmentByCode(String departmentCode) {
        Deparment deparment = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDto(
                deparment.getId(),
                deparment.getDepartmentName(),
                deparment.getDepartmentDescription(),
                deparment.getDepartmentCode()
        );
        return departmentDto;
    }
}
