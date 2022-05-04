package com.alan.hrsys_springboot.util;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null || collection.size() <= 0)
            return;
        ConfigAttribute c;
        String needRole;
        for (Iterator<ConfigAttribute> iter = collection.iterator(); iter.hasNext();) {
            c = iter.next();
            needRole = c.getAttribute();
            System.out.println("needRole--->" + needRole);
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                System.out.println("ga.getAuthority()---->" + ga.getAuthority());
                if (needRole.trim().equals(ga.getAuthority()))
                    return;
            }
        }
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
