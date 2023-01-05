package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Department;
import com.example.demoRestaurant1.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @PersistenceContext

    private EntityManager entityManager;

    @Override
    @Transactional
    public Department saveDepartment(Department department) {
        entityManager.persist(department);
        return department;
    }

    @Override
    @Transactional
    public Department getDepartmentById(int departmentId) {
        Department response = entityManager.find(Department.class, departmentId);
        if (response==null)
            throw new NotFound("department","departmentId",departmentId);
        return response;
    }

    @Override
    @Transactional
    public List<Department> getAllDepartments() {
        return entityManager.createQuery("SELECT departments FROM Department departments")
                .getResultList();
    }
    @Override
    @Transactional
    public Department updateDepartment(Department department, int departmentId){
       Department response = entityManager.find(Department.class, departmentId);
        if (response == null)
            throw new NotFound("department", "departmentId", departmentId);
        return entityManager.merge(department);
    }


}

