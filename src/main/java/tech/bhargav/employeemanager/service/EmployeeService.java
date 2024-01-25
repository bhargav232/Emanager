package tech.bhargav.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bhargav.employeemanager.exception.UserNotFoundException;
import tech.bhargav.employeemanager.model.Employee;
import tech.bhargav.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;


@Service
public class EmployeeService {
    private EmployeeRepo employeerepo;

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

    public void deleteEmployee(Long id){
         employeerepo.deleteEmplopyeeById(id);
    }

    public Employee findEmployeeById(Long id){

        return employeerepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found with ID: " + id));
    }



}
