package tech.bhargav.employeemanager.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bhargav.employeemanager.exception.UserNotFoundException;
import tech.bhargav.employeemanager.model.Employee;
import tech.bhargav.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;


@Service
public class EmployeeService {
    private final EmployeeRepo employeerepo;

    @Autowired
    public EmployeeService( EmployeeRepo employeerepo){
        this.employeerepo = employeerepo;
    }

    public Employee addEmployee(Employee employee){

        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeerepo.save(employee);

    }

    public List<Employee> findAllEmployee(){
        return employeerepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeerepo.save(employee);

    }


    @Transactional
    public void deleteEmployeeById(Long id){

        if (!employeerepo.existsById(id)) {
            System.out.println(id);
            throw new UserNotFoundException("Employee not found with ID: " + id);
        }
         employeerepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){

        return employeerepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found with ID: " + id));
    }



}
