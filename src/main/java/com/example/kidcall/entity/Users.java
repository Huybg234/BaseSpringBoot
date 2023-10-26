package com.example.kidcall.entity;

import com.example.kidcall.cmmn.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", length = 55, unique = true)
    private String userName;

    @Column(name = "full_name", length = 55)
    private String fullName;

    @NotBlank
    @Size(max = 120)
    @Column(name = "password")
    private String password;

    @Column(length = 55, unique = true, name = "email")
    private String email;

    @Column(length = 250, name = "address")
    private String address;

    @Column(length = 55, name = "position")
    private String position;

    @Column(length = 55, name = "gender")
    private boolean gender;

    @Column(length = 55, name = "birth_date")
    private LocalDate birthDate;

    @Column(length = 55, name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Transient
    private Set<UserRole> userRoles;

    public Users() {
    }

    public Users(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.password = password;
    }

    public Users(String userName, String email, String encode, Set<String> role) {
        this.userName = userName;
        this.email = email;
        this.password = encode;
    }
}
