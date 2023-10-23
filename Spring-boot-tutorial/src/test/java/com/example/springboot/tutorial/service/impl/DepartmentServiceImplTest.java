package com.example.springboot.tutorial.service.impl;

import com.example.springboot.tutorial.entity.Department;
import com.example.springboot.tutorial.repository.DepartmentRepository;
import com.example.springboot.tutorial.service.IDepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;
    private IDepartmentService departmentService;

    //Department department;

    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        departmentService = new DepartmentServiceImpl(departmentRepository);
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("casablanca")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        if (found == null) {
            System.out.println("Department not found for name: " + departmentName);
        }
        assertEquals(departmentName, found.getDepartmentName());
    }

}