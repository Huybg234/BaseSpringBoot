package com.example.kidcall.controller;

import com.example.kidcall.cmmn.base.BaseCrudController;
import com.example.kidcall.entity.Users;
import com.example.kidcall.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsersController extends BaseCrudController<Users, Long> {

    @Autowired
    UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
        super.setService(usersService);
    }

    @GetMapping("/userPage")
    public ResponseEntity<?> selectDeptListByUpperID(
            @RequestParam(required = false) Long page,
            @RequestParam(required = false) Long size) {
        return usersService.getAllUserUsePaging(page, size);
    }

}
