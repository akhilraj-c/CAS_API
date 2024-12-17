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
    private String language;

    @Column(columnDefinition = "TEXT")
    private String ipAddress;

    private Long createdTime;
    private Long updatedTime;

    @PrePersist
    public void prePersist() {
        createdTime = System.currentTimeMillis();
        updatedTime = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        updatedTime = System.currentTimeMillis();
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
}
