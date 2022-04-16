package com.alan.hrsys_springboot.dao;

import com.alan.hrsys_springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {


}
