package com.BQA.CAS.modules.clientRegistration;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_client_registration")
@Getter
@Setter
public class ClientRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String browserName;
    private String browserVersion;
    private String platformOS;
    private String appVersion;
    private String deviceToken;

    @Column(columnDefinition = "TEXT")
    private String ipAddress;

    private Integer count;

    private Long createdTime;
    private Long updatedTime;

    private Long createdAppId;
    private Long updatedAppId;

    @PrePersist
    public void prePersist() {
        count = 1;
        createdTime = System.currentTimeMillis();
        updatedTime = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        count = count+1;
        updatedTime = System.currentTimeMillis();
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPlatformOS() {
        return platformOS;
    }

    public void setPlatformOS(String platformOS) {
        this.platformOS = platformOS;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}
