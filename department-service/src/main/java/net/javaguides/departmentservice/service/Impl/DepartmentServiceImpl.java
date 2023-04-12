package net.javaguides.departmentservice.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Convert Department Dto to Department Entity
        Department department =  DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        // convert savedDepartment into DepartmentDto
       // DepartmentDto savedDepartmentDto =
        return DepartmentMapper.maptoDepartmentDto(savedDepartment);
        //return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByByCode(String departmentCode) {
            Department department = departmentRepository.findByDepartmentCode(departmentCode);

           // DepartmentDto departmentDto =
                    return DepartmentMapper.maptoDepartmentDto(department);
       // return departmentDto;
    }
}
