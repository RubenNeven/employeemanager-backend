package com.fullstack.employeemanager.api;

import com.fullstack.employeemanager.api.dto.EmployeeDto;
import com.fullstack.employeemanager.domain.Employee;
import com.fullstack.employeemanager.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/all")
    @ResponseStatus(OK)
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, OK);
    }

    @GetMapping(path = "/find/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") UUID id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDTO){
        logger.info("Into the add employee controller");
        EmployeeDto addEmployee = employeeService.addEmployee(employeeDTO);
        System.out.println(addEmployee);
        return new ResponseEntity<>(addEmployee, CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDTO){
        EmployeeDto updatedEmployeeDTO = employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity<>(updatedEmployeeDTO, OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
       employeeService.deleteEmployee(id);
       return new ResponseEntity<>(OK);
    }
}
