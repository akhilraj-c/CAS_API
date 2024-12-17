package com.BQA.CAS.modules.auth.model;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "appId is required")
    private String appId;

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    public @NotBlank(message = "appId is required") String getAppId() {
        return appId;
    }

    public @NotBlank(message = "username is required") String getUsername() {
        return username;
    }

    public @NotBlank(message = "password is required") String getPassword() {
        return password;
    }
}
