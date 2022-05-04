package com.alan.hrsys_springboot.util;

import com.alan.hrsys_springboot.dao.SysPermissionDao;
import com.alan.hrsys_springboot.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private SysPermissionDao sysPermissionDao;

    //定义存放权限的map
    private HashMap<String, Collection<ConfigAttribute>> map = null;

    public void loadResourceDefine() {
        map = new HashMap<>();
        List<SysPermission> permissions = sysPermissionDao.findAll();
        for (SysPermission permission : permissions) {
            ConfigAttribute cfg = new SecurityConfig(permission.getCode());
            List<ConfigAttribute> list = new ArrayList<>();
            list.add(cfg);
            map.put(permission.getResource(), list);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (map == null)
            loadResourceDefine();
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        System.out.println("=======>>>>"+request.getRequestURL());
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : map.entrySet()) {
            String url = entry.getKey();
            System.out.println("=======>>>>"+url);
            if (new AntPathRequestMatcher(url).matches(request)) {
                System.out.println(map.get(url));
                return map.get(url);
            }

        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
