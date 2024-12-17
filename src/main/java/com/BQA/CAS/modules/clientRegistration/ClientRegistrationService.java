package com.BQA.CAS.modules.clientRegistration;

import com.BQA.CAS.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistrationService {
    @Autowired
    private ClientRegistrationRepository repository;

    public CommonResponse<ClientRegistration> createDevice(ClientRegistration deviceInfo) {
        deviceInfo.setCreatedTime(System.currentTimeMillis());
        deviceInfo.setUpdatedTime(System.currentTimeMillis());
        repository.save(deviceInfo);
        CommonResponse response = new CommonResponse();
        response.setData(deviceInfo);
        return response;
    }
}
