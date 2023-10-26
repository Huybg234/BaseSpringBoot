package com.example.kidcall.controller;

import com.example.kidcall.cmmn.base.Response;
import com.example.kidcall.dto.UserRoleDTO;
import com.example.kidcall.entity.UserRole;
import com.example.kidcall.service.impl.UserRoleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/userRole")
public class UserRoleController{

    @Autowired
    UserRoleServiceImpl service;

    @Autowired
    ModelMapper modelMapper;

    public UserRoleController(UserRoleServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRole(@PathVariable("id") Long id){
        try {
            List<UserRole> userRoles = service.getAll();
            List<UserRole> userRoleList = new ArrayList<>();
            for (UserRole userRole : userRoles){
                if (Objects.equals(userRole.getUser().getId(), id)){
                    userRoleList.add(userRole);
                }
            }
            List<UserRoleDTO> userRoleDTOList = new ArrayList<>();
            for (UserRole userRole : userRoleList){
                UserRoleDTO userRoleDTO = new UserRoleDTO();
                userRoleDTO.setUserId(userRole.getUser().getId());
                userRoleDTO.setRoleId(userRole.getRole().getRoleID());
                userRoleDTOList.add(userRoleDTO);
            }
            return ResponseEntity.ok(new Response().setData(userRoleDTOList).setMessage("Success"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUserRole(@RequestBody UserRoleDTO userRoleDTO){
        try {
            List<UserRole> userRoleList = service.updateUserRole(userRoleDTO);
            return ResponseEntity.ok(new Response().setData(userRoleList).setMessage("Update Success"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
