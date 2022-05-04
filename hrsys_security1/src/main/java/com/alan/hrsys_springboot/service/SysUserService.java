package com.alan.hrsys_springboot.service;


import com.alan.hrsys_springboot.entity.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> search();
    SysUser searchById(Integer id);
    SysUser searchByUsername(String username);
    boolean add(SysUser sysUser);
    boolean update(SysUser sysUser);
    boolean delete(Integer id);


}
