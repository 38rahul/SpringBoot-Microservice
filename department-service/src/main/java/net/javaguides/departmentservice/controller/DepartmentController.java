package net.javaguides.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller exposes REST APIs for Department-Service"
)
public class DepartmentController {

    private DepartmentService departmentService;

    // Build Save Department Rest Api

    @Operation(
            summary = "Save Department REST APIs",
            description = "Save Department REST API is used to save Department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping

    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto saveDepartment =  departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);

    }

    // Build get Department Rest Api
    @Operation(
            summary = "Get Department REST APIs",
            description = "Get Department REST API is used to Get Department object from the  database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @GetMapping("{department-code}")
    public  ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByByCode(departmentCode);

        return  new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }


}
