package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentService {
    public Department saveDepartment(Department department);
    public Department getDepartmentById(int departmentId);
    public List<Department> getAllDepartments();


    Department updateDepartment(Department department, int departmentId);


}
