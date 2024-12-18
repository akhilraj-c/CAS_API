package com.BQA.CAS.modules.auth.model;

import jakarta.persistence.*;

@Table(name = "tbl_user_login_info")
@Entity
public class UserLoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id", nullable = false)
    private Long loginId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "app_id")
    private Long appId;

    @Column(name = "token")
    private String token;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "expiry_time")
    private Long expiryTime;

    @Column(name = "public_key")
    private String publicKey;

    @Column(name = "private_key")
    private String privateKey;

    @Column(name = "aes_key")
    private String aesKey;

    @Column(name = "aes_key_encrypted")
    private String aesKeyEncrypted;

    @Column(name = "created_ip")
    private String createdIp;

    @Column(name = "updated_ip")
    private String updatedIp;

    @Column(name = "created_app_id")
    private Long createdAppId;

    @Column(name = "updated_app_id")
    private Long updatedAppId;

    @Column(name = "created_time")
    public Long createdTime;

    @Column(name = "last_updated_time")
    public Long updatedTime;

    @PrePersist
    public void prePersist() {
        createdTime = System.currentTimeMillis();
        updatedTime = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        updatedTime = System.currentTimeMillis();
    }


//    Getters and setters

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Long expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getAesKeyEncrypted() {
        return aesKeyEncrypted;
    }

    public void setAesKeyEncrypted(String aesKeyEncrypted) {
        this.aesKeyEncrypted = aesKeyEncrypted;
    }

    public String getCreatedIp() {
        return createdIp;
    }

    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }

    public String getUpdatedIp() {
        return updatedIp;
    }

    public void setUpdatedIp(String updatedIp) {
        this.updatedIp = updatedIp;
    }

    public Long getCreatedAppId() {
        return createdAppId;
    }

    public void setCreatedAppId(Long createdAppId) {
        this.createdAppId = createdAppId;
    }

    public Long getUpdatedAppId() {
        return updatedAppId;
    }

    public void setUpdatedAppId(Long updatedAppId) {
        this.updatedAppId = updatedAppId;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }
}
