package com.alan.hrsys_springboot;

import com.alan.hrsys_springboot.dao.EmployeeDao;
import com.alan.hrsys_springboot.entity.Department;
import com.alan.hrsys_springboot.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeDaoTest {
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSearchAll() {
        List<Employee> list = employeeDao.findAll();
        for (Employee emp : list)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testSearchOne() {
        Employee emp = employeeDao.getOne(2);
        Employee e = new Employee();
        System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testSearchOneBtId() {
        Employee emp = employeeDao.findById(3).get();
        Employee e = new Employee();
        System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testAdd() {
        Employee emp = new Employee();
        emp.setName("天女蕊");
        emp.setNumber(10005);
        emp.setGender("女");
        emp.setAge(20);
        Employee newEmp = employeeDao.save(emp);
        System.out.println(newEmp.getId());
    }

    @Test
    public void testUpdate() {
        Employee emp = employeeDao.findById(1).get();
        emp.setNumber(10009);
        emp.setAge(26);
        Employee newEmp = employeeDao.save(emp);
        System.out.println(newEmp.getId());
    }

    @Test
    public void testDelete() {
        employeeDao.deleteById(5);
    }

/*    @Test
    public void testFindByGender() {
        List<Employee> list = employeeDao.findByGender("女");
        for (Employee emp : list)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testFindByGenderAndAge() {
        List<Employee> list = employeeDao.findByGenderAndAge("男", 22);
        for (Employee emp : list)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testFindByNameGenderAndAge() {
        List<Employee> list = employeeDao.findByNameAndGenderAndAge("唐三","男", 19);
        for (Employee emp : list)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testFindByNameContainingGenderAndAge() {
        List<Employee> list = employeeDao.findByNameContainingAndGenderAndAge("李","男", 22);
        for (Employee emp : list)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }

    @Test
    public void testJPQL() {
        List<Employee> list = employeeDao.find();
        for (Employee emp : list)
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getGender());
    }*/

    @Test
    public void testSearchWithDep() {
        List<Employee> list = employeeDao.findAll();
        for (Employee emp : list) {
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDep().getName());
        }
    }

    @Test
    public void tsetAddWithDep() {
        Employee emp = new Employee();
        emp.setNumber(1011);
        emp.setName("李明");
        Department dep = new Department();
        dep.setName("测试部");
        emp.setDep(dep);
        Employee newEmp =employeeDao.save(emp);
        System.out.println(newEmp.getId());
    }

}
