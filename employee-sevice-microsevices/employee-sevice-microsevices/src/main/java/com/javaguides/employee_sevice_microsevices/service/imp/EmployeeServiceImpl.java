package com.javaguides.employee_sevice_microsevices.service.imp;

import com.javaguides.employee_sevice_microsevices.dto.ApiResponseDto;
import com.javaguides.employee_sevice_microsevices.dto.DepartmentDto;
import com.javaguides.employee_sevice_microsevices.dto.EmployeeDto;
import com.javaguides.employee_sevice_microsevices.entity.Employee;
import com.javaguides.employee_sevice_microsevices.repository.EmployeeRepository;
import com.javaguides.employee_sevice_microsevices.service.Employeeservice;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements Employeeservice {
    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
          employeeDto.getId(),
          employeeDto.getFirstName(),
          employeeDto.getLastName(),
          employeeDto.getEmail(),
                employeeDto.getDepartmentCode()

        );
        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
          saveDEmployee.getId(),
          saveDEmployee.getFirstName(),
          saveDEmployee.getLastName(),
          saveDEmployee.getEmail(),
                saveDEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    @Override
        public ApiResponseDto getEmployeeFirstName(Long employeeId) {
       Employee employeesave =  employeeRepository.findById(employeeId).get();
System.out.println("Microservices communication using Rest Template");
     ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/departments/"+employeesave.getDepartmentCode(), DepartmentDto.class);
       System.out.println("response entity");
        DepartmentDto departmentDto = responseEntity.getBody();
       EmployeeDto employeeDto = new EmployeeDto(
               employeesave.getId(),
               employeesave.getFirstName(),
               employeesave.getLastName(),
               employeesave.getEmail(),
               employeesave.getDepartmentCode()
       );

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }


}
