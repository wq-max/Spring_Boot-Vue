package com.alan.hrsys_springboot.service;


import com.alan.hrsys_springboot.entity.SysRole;

import java.util.List;

public interface SysRoleService {
     List<SysRole> search();
    boolean add(SysRole sysRole);

    boolean delete(Integer id);

     SysRole searchById(Integer id);

    boolean update(SysRole sysRole);
}
