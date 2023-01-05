package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.model.Department;
import com.example.demoRestaurant1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{departmentId}", method = RequestMethod.GET)
    public ResponseEntity<Department> getDepartmentById(@PathVariable int departmentId) {

        return new ResponseEntity<Department>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> getAllDepartments() {

        return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{departmentId}", method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable int departmentId) {

        return new ResponseEntity<Department>(departmentService.updateDepartment(department, departmentId), HttpStatus.OK);
    }


}


