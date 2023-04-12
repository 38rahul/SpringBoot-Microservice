package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.ApiClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;

   // @Autowired
    //private WebClient webClient;

    @Autowired
    private WebClient.Builder webClientBuilder;
@Autowired
    private ApiClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveEmployee);
        //return EmployeeMapper.mapToEmployeeDto(employee);
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClientBuilder.build().get() //webClient.get()
                .uri("http://localhost:8080/api/departments/"+ employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block() ;  // to make synchronous call

        //DepartmentDto departmentDto  = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClientBuilder.build().get()//webClient.get()
                .uri("http://localhost:8085/api/organization/" + employee.getOrganizationCode())
                //.uri("http://ORGANIZATION-SERVICE/" + employee.getOrganizationCode())
                // "http://bookmark-service/{userId}/bookmarks",
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto  employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }



}


// 8: 00
