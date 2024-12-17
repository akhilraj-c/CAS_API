package com.BQA.CAS.common.constants.Enum;

public enum ApplicationStatus {
    INSTITUTION_REGISTERED(1,"Institution complete and submit the registration form"),
    DFO_ADMIN_REJECTED(3 , "DFO Admin rejected the registration and did not schedule the application"), //done
    DFO_ADMIN_APPROVED(5, "DFO Admin add a submission date for the application submission and approve"), //done

    ;
    private final Integer code;
    private final String name;

    ApplicationStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
