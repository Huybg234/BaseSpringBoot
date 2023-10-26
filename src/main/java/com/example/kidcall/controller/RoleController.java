package com.example.kidcall.controller;

import com.example.kidcall.cmmn.base.BaseCrudController;
import com.example.kidcall.entity.Role;
import com.example.kidcall.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController extends BaseCrudController<Role, Long> {

    @Autowired
    RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
        super.setService(roleService);
    }

}
