package com.thaopx.demoCRUD.controller;

import com.thaopx.demoCRUD.models.Employee;
import com.thaopx.demoCRUD.models.ResponseObject;
import com.thaopx.demoCRUD.repositories.EmployeeRepository;
import com.thaopx.demoCRUD.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    //add
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addEmployee(@RequestBody Employee employee){
        return iEmployeeService.addEmployee(employee);
    }

    // find all
    @GetMapping("/list")
    public ResponseEntity<ResponseObject> getAllEmployee(){
        return iEmployeeService.getAllEmployee();
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestParam long id, @RequestBody Employee employee ){
        return iEmployeeService.updatEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteEmployee(@PathVariable("id") long id){
        return iEmployeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getOneEmployee(@PathVariable("id") long id){
        return iEmployeeService.getOneEmployee(id);
    }

}
