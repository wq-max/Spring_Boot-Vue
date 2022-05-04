package com.alan.hrsys_springboot.service.impl;

import com.alan.hrsys_springboot.entity.SysPermission;
import com.alan.hrsys_springboot.entity.SysRole;
import com.alan.hrsys_springboot.entity.SysUser;
import com.alan.hrsys_springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser sysUser = sysUserService.searchByUsername(s);
        if (sysUser == null)
            throw new UsernameNotFoundException("用户名不存在");
        //添加角色
        List<SysRole> sysRoles = sysUser.getRoles();
        for (SysRole sysRole : sysRoles) {
            authorities.add(new SimpleGrantedAuthority(sysRole.getCode()));
            //添加权限
            for (SysPermission sysPermission : sysRole.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }
}
