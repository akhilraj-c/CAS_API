package com.BQA.CAS.common.constants;

public final class ApiUrls {
    public static final String BASE_URL = "/api/";
    public static final String INSTITUTION_REGISTRATION = BASE_URL + "auth/user/form-submission";
    public static final String LOGIN = BASE_URL + "auth/login";
    public static final String APP_REGISTRATION = BASE_URL + "auth/app/registration";
    public static final String APPROVE_INSTITUTE = BASE_URL + "dfo/approve-institute";
    public static final String REJECT_INSTITUTE = BASE_URL + "dfo/reject-institute";
    public static final String APPROVE_EDUSCRIBE = BASE_URL + "user/approve-eduscribe";
    public static final String GET_ALL_INSTITUTES = BASE_URL + "dfo/get-institute";
    public static final String GET_INSTITUTE_BY_EMAIL = BASE_URL + "institute/get-institute";
    public static final String GET_INSTITUTE_DETAILS = BASE_URL + "user/get-institute-details";
}
