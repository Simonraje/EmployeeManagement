package Project1.EmployeeManagement.service.implementation;

import Project1.EmployeeManagement.dto.DepartmentDto;
import Project1.EmployeeManagement.entity.Department;
import Project1.EmployeeManagement.mapper.DepartmentMapper;
import Project1.EmployeeManagement.repository.DepartmentRepository;
import Project1.EmployeeManagement.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
