package com.oop442.project.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String contactNumber;
    private String companyName;
    private String gstRegistrationNumber;
    private String natureOfBusiness;
}
