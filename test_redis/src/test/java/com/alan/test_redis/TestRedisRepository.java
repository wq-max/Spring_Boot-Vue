package com.alan.test_redis;

import com.alan.test_redis.dao.EmployeeDao;
import com.alan.test_redis.entity.Department;
import com.alan.test_redis.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
public class TestRedisRepository {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void setEmp() {
        Department dep1 = new Department();
        dep1.setId(1);
        dep1.setName("开发部");
        Department dep2 = new Department();
        dep2.setId(2);
        dep2.setName("营销部");
        Employee emp1 = new Employee();
        emp1.setName("李静");
        emp1.setGender("女");
        emp1.setAge(25);
        emp1.setDep(dep2);
        Employee emp2 = new Employee();
        emp2.setName("王正");
        emp2.setGender("男");
        emp2.setAge(30);
        emp2.setDep(dep1);
        employeeDao.save(emp1);
        employeeDao.save(emp2);
    }

    @Test
    void getEmps() {
        Iterable<Employee> iterable = employeeDao.findAll();
        for (Employee emp : iterable) {
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender() + " " + emp.getAge() + " " + emp.getDep().getName());
        }
    }

    @Test
    void getEmp() {
        Employee emp = employeeDao.findById(155436384).get();
        System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender() + " " + emp.getAge() + " " + emp.getDep().getName());
    }

    @Test
    void getEmpByName() {
        Iterable<Employee> iterable = employeeDao.findByName("李静");
        for (Employee emp : iterable)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender() + " " + emp.getAge() + " " + emp.getDep().getName());
    }
}
