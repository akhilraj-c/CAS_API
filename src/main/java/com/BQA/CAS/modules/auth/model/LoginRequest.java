package com.BQA.CAS.modules.auth.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "appId must not be null")
    private Long appId;

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    public @NotNull(message = "appId must not be null") Long getAppId() {
        return appId;
    }

    public @NotBlank(message = "username is required") String getUsername() {
        return username;
    }

    public @NotBlank(message = "password is required") String getPassword() {
        return password;
    }
}
