package com.example.kidcall.service.impl;

import com.example.kidcall.cmmn.base.BaseCrudService;
import com.example.kidcall.cmmn.base.Response;
import com.example.kidcall.entity.Users;
import com.example.kidcall.repository.RoleRepository;
import com.example.kidcall.repository.UsersRepository;
import com.example.kidcall.repository.UsersRoleRepository;
import com.example.kidcall.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceImpl extends BaseCrudService<Users, Long> implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersRoleRepository usersRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        super.setRepository(usersRepository);
    }

    @Override
    public ResponseEntity<?> select() {
        try {
            List<Users> usersList = usersRepository.findAll();
            return ResponseEntity.ok(new Response().setDataList(usersList).setMessage("Successfully!"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> save(Users users) {
        if (users.getId() == null) {
            try {
                users.setPassword(encoder.encode(users.getPassword()));
                Users userEntity = usersRepository.save(users);
                return super.save(userEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Optional<Users> studentEntity = usersRepository.findById(users.getId());
            try {
                studentEntity.get().setUserName(users.getUserName());
                studentEntity.get().setEmail(users.getEmail());
                studentEntity.get().setPassword(encoder.encode(users.getPassword()));
                super.save(studentEntity.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok(new Response().setData(studentEntity).setMessage("Updated"));
        }
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (id != null) {
            try {
                super.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("Invalid user id");
            }
        }
        return ResponseEntity.ok("Success");
    }

    @Override
    public ResponseEntity<?> getAllUserUsePaging(Long page, Long size) {
        Pageable paging = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
        Page<Users> usersPage = usersRepository.selectDeptListUsePaging(paging);

        List<Users> users = usersPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("users", users);
        response.put("currentPage", usersPage.getNumber());
        response.put("totalItems", usersPage.getTotalElements());
        response.put("totalPages", usersPage.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
