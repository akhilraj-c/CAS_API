package com.BQA.CAS.modules.clientRegistration;

import com.BQA.CAS.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.BQA.CAS.common.constants.ApiUrls;


@RestController
public class ClientRegistrationController {
    @Autowired
    ClientRegistrationService service;

    @PostMapping(ApiUrls.APP_REGISTRATION)
    public ResponseEntity<CommonResponse<ClientRegistration>> createDevice(@RequestBody ClientRegistration request) {
        try{
            CommonResponse<ClientRegistration> response = service.createDevice(request);
            return ResponseEntity.ok(response);
        }catch (Exception e){
           throw e;
        }

    }
}
