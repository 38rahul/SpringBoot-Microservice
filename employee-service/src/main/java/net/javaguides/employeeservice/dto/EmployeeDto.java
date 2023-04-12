package net.javaguides.employeeservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lasttName;
    private String email;
    private String departmentCode;
    private  String organizationCode;
}
