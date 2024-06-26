package Project1.EmployeeManagement.repository;

import Project1.EmployeeManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
