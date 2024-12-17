package com.BQA.CAS.authentication;

import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = new ErrorResponse(
                "Authentication failed...!",
                HttpStatus.UNAUTHORIZED.value(),
                "Unauthorized access",
                System.currentTimeMillis()
        );
        CommonResponse responseData = new CommonResponse();
        responseData.setData(errorResponse);
        mapper.writeValue(response.getOutputStream(), responseData);
    }
}
