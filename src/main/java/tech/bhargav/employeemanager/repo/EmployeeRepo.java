package tech.bhargav.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.bhargav.employeemanager.model.Employee;

import java.util.Optional;


// adding repo for datalayer communication

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmplopyeeById(Long id);

    Optional <Employee> findEmployeeById(Long id);

}
