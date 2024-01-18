package com.thaopx.demoCRUD.service;

import com.thaopx.demoCRUD.models.Employee;
import com.thaopx.demoCRUD.models.ResponseObject;
import com.thaopx.demoCRUD.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// xử lý logic
@Service
public class EmployeeImpl implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<ResponseObject> addEmployee(Employee employee) {
        // them moi 1 object
        List<Employee> employeeList = employeeRepository.findByName(employee.getName().trim());
        return employeeList.size() > 0 ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Employee already exist", "")
                )
                :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Employee insert already taken", employeeRepository.save(employee))
                );
    }

    @Override
    public ResponseEntity<ResponseObject> updatEmployee(long id, Employee newEmployee) {
        // neu có data thi sua/ chua co thi them moi
        Employee updatedProduct = employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setAddress(newEmployee.getAddress());
                    return employeeRepository.save(employee);
                }).orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update Product successfully", updatedProduct)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> deleteEmployee(long id) {
        boolean exists = employeeRepository.existsById(id);
        if(exists) {
            employeeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product to delete", "")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> getAllEmployee() {
        List<Employee> list = employeeRepository.findAll();
        return list.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query product successfully", list)
                        //you can replace "ok" with your defined "error code"
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "List is empty", list)
                );
    }

    @Override
    public ResponseEntity<ResponseObject> getOneEmployee(long id) {
        Optional<Employee> foundProduct = employeeRepository.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query product successfully", foundProduct)
                        //you can replace "ok" with your defined "error code"
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id = " + id, "")
                );

    }
}
