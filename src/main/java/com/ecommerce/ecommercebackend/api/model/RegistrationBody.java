package com.ecommerce.ecommercebackend.api.model;

import jakarta.validation.constraints.*;

public class RegistrationBody {

    @NotNull
    @NotBlank
    @Size(min = 6, max = 255)
    private  String username;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,16}$")
    @Size(min = 6, max = 16)
    private  String password;
    @NotNull
    @NotBlank
    @Email
    private  String email;
    @NotNull
    @NotBlank
    private  String firstName;

    @NotNull
    @NotBlank
    private  String lastName;

    public RegistrationBody() {
    }

    public RegistrationBody(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
