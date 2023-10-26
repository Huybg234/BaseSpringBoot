package com.example.kidcall.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface UsersDTO {

    public Long getUserID();

    public String getUserName();

    public String getFullName();

    public String getEmail();

    public String getAddress();

    public String getPosition();

    public LocalDate getBirthDate();

    public boolean getGender();

    public String getPhoneNumber();

    public LocalDateTime getCreatedAt();
}
