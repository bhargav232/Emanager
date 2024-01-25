package tech.bhargav.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bhargav.employeemanager.exception.UserNotFoundException;
import tech.bhargav.employeemanager.model.Employee;
import tech.bhargav.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
            public EmployeeController(EmployeeService employeeService){
                this.employeeService = employeeService;
            }

            // Return all employess
            @GetMapping("/all")
            public ResponseEntity<List<Employee>> getAllEmployees(){
                List<Employee> employees = employeeService.findAllEmployee();
                return new ResponseEntity<>(employees, HttpStatus.OK);
            }

            // Return employee of specific id
            @GetMapping("/find/{id}")
            public ResponseEntity<?> getAllEmployeeById(@PathVariable("id") Long id){

               try{
                    Employee employee = employeeService.findEmployeeById(id);
                    return new ResponseEntity<>(employee, HttpStatus.OK);
                }
               catch (UserNotFoundException ex){
                   return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
               }


            }

            // POST mapping for adding new employee
            @PostMapping("add")
            public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
                Employee newEmployee = employeeService.addEmployee(employee);
                return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
            }


            // put request for updating an employee
            @PutMapping("/update/id")
            public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
                Employee updateEmployee = employeeService.updateEmployee(employee);
                return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
            }

            @DeleteMapping("/delete/{id}")
            public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
                try {
                    employeeService.deleteEmployeeById(id);
                    return new ResponseEntity<>("Employee deleted with ID: " + id, HttpStatus.OK);
                }
                catch (UserNotFoundException ex){
                    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
                }
            }
}
