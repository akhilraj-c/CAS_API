package com.BQA.CAS.modules.auth;

import com.BQA.CAS.common.constants.ApiUrls;
import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.modules.auth.model.LoginRequest;
import com.BQA.CAS.modules.auth.model.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(ApiUrls.LOGIN)
    public ResponseEntity<CommonResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        try{
            CommonResponse<LoginResponse> response = authService.login(request);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            throw e;
        }
    }

}
