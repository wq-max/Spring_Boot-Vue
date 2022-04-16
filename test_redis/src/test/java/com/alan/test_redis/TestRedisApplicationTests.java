package com.alan.test_redis;

import com.alan.test_redis.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import com.sun.beans.TypeResolver;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, Employee> redisTemplateObj;

    @Test
    void contextLoads() {
    }

    @Test
    void setString() {
        redisTemplate.opsForValue().set("name", "Tom");
    }

    @Test
    void getString() {
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void updateString() {
        String name = redisTemplate.opsForValue().getAndSet("name", "李静");
        System.out.println(name);
    }

    @Test
    void deleteString() {
        Boolean flag = redisTemplate.delete("name");
        if (Boolean.TRUE.equals(flag))
            System.out.println("delete successful!");
        else System.out.println("delete fail!");
    }

    @Test
    void setList() {
        redisTemplate.opsForList().leftPush("emps", "王正");
        String[] strs = {"李静", "陈建"};
        redisTemplate.opsForList().leftPushAll("emps", strs);
        List<String> list = new ArrayList<>();
        list.add("赵杰");
        list.add("孙悦");
        redisTemplate.opsForList().leftPushAll("emps", list);
    }

    @Test
    void getList() {
        String emp = redisTemplate.opsForList().index("emps", 0);
        System.out.println(emp);
    }

    @Test
    void setEmp() {
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("李静");
        emp1.setGender("女");
        emp1.setAge(25);
        redisTemplateObj.opsForValue().set("emp1", emp1);
    }

    @Test
    void getEmp() {
        Employee emp = redisTemplateObj.opsForValue().get("emp1");
        assert emp != null;
        System.out.println(emp.getName());
    }

    @Test
    void setEmps() {
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("李静");
        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("王正");
        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        redisTemplateObj.opsForList().leftPushAll("Emp", list);
    }

    @Test
    void getEmps() {
        Employee emp = redisTemplateObj.opsForList().index("Emp", 0);
        assert emp != null;
        System.out.println(emp.getName());
    }

}
