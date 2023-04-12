package net.javaguides.employeeservice.mapper;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getDepartmentCode(),
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLasttName(),
                employee.getOrganizationCode()
        );
        return employeeDto;
    }

    public static  Employee mapToEmployee (EmployeeDto employeeDto){
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLasttName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode()
        );
       return  employee;
    }
}
