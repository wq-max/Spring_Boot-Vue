package com.alan.hrsys_springboot;

import com.alan.hrsys_springboot.dao.DepartmentDao;
import com.alan.hrsys_springboot.entity.Department;
import com.alan.hrsys_springboot.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DepartmentDaoTest {

    @Autowired
    DepartmentDao depDao;

   @Test
    public void testSearch() {
        List<Department> list = depDao.findAll();
        for (Department dep : list) {
            System.out.println(dep.getId() + " " + dep.getName() + " ");
        }
    }

    /*@Test
    public void testAddWithEmp() {
        Department dep = new Department();
        dep.setName("质量部");
        Employee emp1 = new Employee();
        emp1.setName("李明");
        emp1.setNumber(1021);
        emp1.setDep(dep);
        Employee emp2 = new Employee();
        emp2.setNumber(1022);
        emp2.setName("李小明");
        emp2.setDep(dep);
        List<Employee> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp2);
        dep.setEmps(emps);
        Department newDep = depDao.save(dep);
        System.out.println(newDep.getId());
    }*/
}
