package com.javaguides.Department_sevice_microsevices.controller;

import com.javaguides.Department_sevice_microsevices.dto.DepartmentDto;
import com.javaguides.Department_sevice_microsevices.service.DeartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DeartmentService deartmentService;

    //Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment (@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmet = deartmentService.saveDepatmentService(departmentDto);
        return new ResponseEntity<>(savedDepartmet, HttpStatus.CREATED);
    }

    //Build get department rest api
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        System.out.println("enter into get mapping");
        DepartmentDto departmentDto = deartmentService.getDeparmentByCode(departmentCode);
        System.out.println(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
