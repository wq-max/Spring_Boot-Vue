package com.alan.hrsys_springboot.service.impl;

import com.alan.hrsys_springboot.dao.SysRoleDao;
import com.alan.hrsys_springboot.entity.SysRole;
import com.alan.hrsys_springboot.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> search() {
        return sysRoleDao.findAll();
    }

    @Override
    public boolean add(SysRole sysRole) {
        return sysRoleDao.save(sysRole)!=null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            sysRoleDao.deleteById(id);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public SysRole searchById(Integer id) {
        return sysRoleDao.findById(id).get();
    }

    @Override
    public boolean update(SysRole sysRole) {
        return sysRoleDao.save(sysRole)!=null;
    }
}
