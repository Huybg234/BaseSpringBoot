package com.example.kidcall.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class SignupRequest {
    private String userName;

    //    @NotBlank
    private String fullName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    //    @NotBlank
    private String address;

    //    @NotBlank
    private String position;

    private Set<String> role;

    private String password;
}
