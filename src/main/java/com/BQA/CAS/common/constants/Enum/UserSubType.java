package com.BQA.CAS.common.constants.Enum;

import lombok.Getter;

@Getter
public enum UserSubType {

    ADMIN(0, "Admin type" ),
    USER(2, "User type" ),
    MANAGER(1, "Manager type"),

    ;

    private final Integer code;
    private final String message;

    UserSubType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static UserSubType getByCode(Integer code) {

        for (UserSubType user : values()) {
            if (user.getCode() == code) {
                return user;
            }
        }
        return null;
    }


}