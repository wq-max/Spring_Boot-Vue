package com.alan.test_redis.dao;

import com.alan.test_redis.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findByName(String name);
}
