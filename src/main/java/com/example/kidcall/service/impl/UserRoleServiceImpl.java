package com.example.kidcall.service.impl;

import com.example.kidcall.cmmn.base.BaseCrudService;
import com.example.kidcall.dto.UserRoleDTO;
import com.example.kidcall.entity.Role;
import com.example.kidcall.entity.UserRole;
import com.example.kidcall.entity.Users;
import com.example.kidcall.repository.UsersRepository;
import com.example.kidcall.repository.UsersRoleRepository;
import com.example.kidcall.service.UserRoleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRoleServiceImpl extends BaseCrudService<UserRole, Long> implements UserRoleSerivce {

    @Autowired
    UsersRoleRepository usersRoleRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UserRole> getAll() {
        return usersRoleRepository.findAll();
    }

    public List<UserRole> updateUserRole(UserRoleDTO userRoleDTO) {
        try{
            Optional<Users> user = usersRepository.findById(userRoleDTO.getUserId());
            List<UserRole> userRoleList = new ArrayList<>();
            Set<Role> roles = userRoleDTO.getRoles();
            if (user.isPresent()){
                for (Role role : roles) {
                    UserRole userRole = new UserRole();
                    userRole.setRole(role);
                    userRole.setUser(user.get());
                    userRoleList.add(userRole);
                }
            }
            return usersRoleRepository.saveAll(userRoleList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
