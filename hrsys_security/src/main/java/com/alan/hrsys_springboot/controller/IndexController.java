package com.alan.hrsys_springboot.controller;

import com.alan.hrsys_springboot.entity.SysUser;
import com.alan.hrsys_springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        SysUser user = sysUserService.searchByUsername(username);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("loginError")
    public String showLoginError() {
        return "loginError";
    }

    @RequestMapping("roleError")
    public String showRoleError() {
        return "roleError";
    }
}
