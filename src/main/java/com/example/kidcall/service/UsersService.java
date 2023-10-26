package com.example.kidcall.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface UsersService {

    ResponseEntity<?> getAllUserUsePaging(Long page, Long size);
}
