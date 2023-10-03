package com.example.springboot.tutorial.service;

import com.example.springboot.tutorial.entity.Department;
import com.example.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface IDepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepatmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
