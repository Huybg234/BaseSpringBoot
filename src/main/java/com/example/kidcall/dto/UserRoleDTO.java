package com.example.kidcall.dto;

import com.example.kidcall.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private Long userId;
    private Long roleId;
    private Set<Role> roles;
}
