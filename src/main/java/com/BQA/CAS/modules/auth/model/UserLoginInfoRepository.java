package com.BQA.CAS.modules.auth.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginInfoRepository extends JpaRepository<UserLoginInfo,Long> {
    UserLoginInfo getByUserIdAndAppId(Long userId, Long appId);
}
