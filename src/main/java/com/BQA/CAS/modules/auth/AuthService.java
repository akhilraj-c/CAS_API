package com.BQA.CAS.modules.auth;

import com.BQA.CAS.authentication.JwtUtils;
import com.BQA.CAS.common.constants.Enum.UserType;
import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.modules.auth.model.*;
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

    @Autowired
    UserLoginInfoRepository userLoginInfoRepository;

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
        if(request.getAppId()==null){
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
            throw new IllegalArgumentException("Request failed: Invalid username or password.");
        }

        String token = jwtUtils.generateToken(request.getUsername());
        String refreshToken = jwtUtils.generateRefreshToken(request.getUsername());
        LoginResponse response = new LoginResponse();

        UserLoginInfo userLoginInfo = userLoginInfoRepository.getByUserIdAndAppId(userOpt.get().getUserId(),request.getAppId());
        if (userLoginInfo == null) {
            userLoginInfo = new UserLoginInfo();
            userLoginInfo.setUserId(userOpt.get().getUserId());
            userLoginInfo.setUserType(userOpt.get().getUserType());
            userLoginInfo.setAppId(request.getAppId());
            userLoginInfo.setCreatedAppId(request.getAppId());
        }
        userLoginInfo.setToken(token);
        userLoginInfo.setRefreshToken(refreshToken);
        userLoginInfo.setExpiryTime(System.currentTimeMillis() + jwtUtils.jwtExpirationMs);
        userLoginInfo.setUpdatedAppId(request.getAppId());
//        userLoginInfo.setPublicKey(publicKey);
//        userLoginInfo.setPrivateKey(privateKey);
//        userLoginInfo.setAesKey(aesKey);
//        userLoginInfo.setAesKeyEncrypted(encryptedAESKey);

        userLoginInfoRepository.save(userLoginInfo);
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
