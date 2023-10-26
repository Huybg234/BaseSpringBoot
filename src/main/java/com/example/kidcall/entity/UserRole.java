package com.example.kidcall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "role_id"})
})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ROLE_SEQ")
    @SequenceGenerator(name = "USERS_ROLE_SEQ", sequenceName = "USERS_ROLE_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "user_role_id")
    private Long userRoleID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole(Users user, Role role) {
        this.user = user;
        this.role = role;
    }
}
