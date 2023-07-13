package com.thaopx.demoCRUD.service;

import com.thaopx.demoCRUD.models.Employee;
import com.thaopx.demoCRUD.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {

    // them nhan vien
    public ResponseEntity<ResponseObject> addEmployee(Employee employee);

    // sua nhan vien
    public ResponseEntity<ResponseObject> updatEmployee(long id, Employee employee);

    //xoa nhan vien
    public ResponseEntity<ResponseObject> deleteEmployee(long id);

    //get all nhan vien
    public ResponseEntity<ResponseObject> getAllEmployee();

    //lay 1 nhan vien
    public ResponseEntity<ResponseObject> getOneEmployee(long id);
}
