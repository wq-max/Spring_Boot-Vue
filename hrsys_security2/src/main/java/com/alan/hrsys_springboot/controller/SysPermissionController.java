package com.alan.hrsys_springboot.controller;

import com.alan.hrsys_springboot.entity.SysPermission;
import com.alan.hrsys_springboot.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysPermission")
@PreAuthorize("hasAuthority('sysPermission')")
public class SysPermissionController {

	@Autowired
    SysPermissionService sysPermissionService;

	@RequestMapping("search")
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView("sysPermission/show");
		List<SysPermission> list = sysPermissionService.search();
		mv.addObject("list", list);

		return mv;

	}

	@RequestMapping("showAdd")
	public String showAdd() {
		return "sysPermission/add";

	}

	@RequestMapping("add")
	public String add(SysPermission sysPermission) {
		boolean flag = sysPermissionService.add(sysPermission);
		return "redirect:search";

	}

	@RequestMapping("showUpdate")
	public ModelAndView showUpdat(Integer id) {
		ModelAndView mv = new ModelAndView("sysPermission/update");
		SysPermission sysPermission = sysPermissionService.searchById(id);
		mv.addObject("sysPermission", sysPermission);
		return mv;

	}

	@RequestMapping("update")
	public String update(SysPermission sysPermission) {
		boolean flag = sysPermissionService.update(sysPermission);
		return "redirect:search";
	}

	@RequestMapping("delete")
	public String delete(Integer id) {
		boolean flag = sysPermissionService.delete(id);
		return "redirect:search";
	}
}
