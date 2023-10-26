package com.example.kidcall.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(name = "ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "role_id")
    private Long roleID;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole roleName;

//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
//    private Set<UserRole> userRoles;

}
