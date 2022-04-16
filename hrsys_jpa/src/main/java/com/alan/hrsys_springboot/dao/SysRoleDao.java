package com.alan.hrsys_springboot.dao;

import com.alan.hrsys_springboot.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleDao extends JpaRepository<SysRole, Integer> {
}
