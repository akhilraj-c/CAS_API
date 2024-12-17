package com.BQA.CAS.modules.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "user_type")
    private int userType;

    @Column(name = "sub_type")
    private int subType;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "active")
    private Integer active;

    @Column(name = "bio")
    private String bio;

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

    @Column(name = "updated_time")
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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
}
