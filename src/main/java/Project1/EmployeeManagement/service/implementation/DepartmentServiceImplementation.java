package Project1.EmployeeManagement.service.implementation;

import Project1.EmployeeManagement.dto.DepartmentDto;
import Project1.EmployeeManagement.entity.Department;
import Project1.EmployeeManagement.exception.ResourceNotFoundException;
import Project1.EmployeeManagement.mapper.DepartmentMapper;
import Project1.EmployeeManagement.repository.DepartmentRepository;
import Project1.EmployeeManagement.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department does not exist in given id: "+departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
            new ResourceNotFoundException("Department does not exist")
        );
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteById(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department doesnot Exists!"));
        departmentRepository.deleteById(departmentId);
    }


}
