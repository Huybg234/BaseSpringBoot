package com.example.kidcall.repository;

import com.example.kidcall.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM users")
    Page<Users> selectDeptListUsePaging(Pageable pageable);
}
