package com.BQA.CAS.modules.auth;

import com.BQA.CAS.authentication.JwtUtils;
import com.BQA.CAS.common.constants.Enum.UserType;
import com.BQA.CAS.common.constants.ErrorCode;
import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.modules.auth.model.LoginRequest;
import com.BQA.CAS.modules.auth.model.LoginResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public String register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return "User registered successfully!";
    }

    public CommonResponse<LoginResponse> login(LoginRequest request) {
        if(request.getAppId().isEmpty()){
            throw new RuntimeException("AppId is required!");
        }
        if(request.getUsername().isEmpty()){
            throw new RuntimeException("username is required!");
        }
        if(request.getPassword().isEmpty()){
            throw new RuntimeException("password is required!");
        }
        Optional<User> userOpt = userRepository.findByEmail(request.getUsername());

        if (userOpt.isEmpty() || !request.getPassword().equals(userOpt.get().getPassword())) {
            throw new RuntimeException("Invalid username or password!");
        }
        String token = jwtUtils.generateToken(request.getUsername());
        LoginResponse response = new LoginResponse();
        response.setAppId(request.getAppId());
        response.setUsername(userOpt.get().getEmail());
        response.setUserType(userOpt.get().getUserType());
        response.setSubType(userOpt.get().getSubType());
        response.setUserId(userOpt.get().getUserId());
        response.setToken(token);
        CommonResponse finalResponse = new CommonResponse();
        finalResponse.setData(response);

        return finalResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getByEmail(username);
        if (user == null) {
            throw new ServiceException("User not found");
        }
        UserType userType = UserType.getByCode(user.getUserType(),user.getSubType());
        if (userType == null) {
            throw new ServiceException("User Type Not Found");
        }
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userType.getDescription());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                List.of(simpleGrantedAuthority));
    }
}
