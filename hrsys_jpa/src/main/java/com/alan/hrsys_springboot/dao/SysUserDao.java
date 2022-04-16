package com.alan.hrsys_springboot.dao;

import com.alan.hrsys_springboot.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserDao extends JpaRepository<SysUser,Integer>{
}
