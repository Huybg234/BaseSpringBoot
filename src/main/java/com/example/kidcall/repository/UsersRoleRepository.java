package com.example.kidcall.repository;


import com.example.kidcall.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRoleRepository extends JpaRepository<UserRole, Long> {
}
