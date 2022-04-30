package com.alan.hrsys_springboot.dao;

import com.alan.hrsys_springboot.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysPermissionDao extends JpaRepository<SysPermission,Integer> {
}
