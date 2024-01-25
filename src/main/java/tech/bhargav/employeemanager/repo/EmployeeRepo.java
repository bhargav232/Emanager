package tech.bhargav.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.bhargav.employeemanager.model.Employee;

import java.util.Optional;


// adding repo for datalayer communication

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    void deleteEmployeeById(@Param("id") Long id);

    Optional <Employee> findEmployeeById(Long id);

}
