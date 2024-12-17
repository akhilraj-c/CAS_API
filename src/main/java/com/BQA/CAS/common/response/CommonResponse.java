package com.BQA.CAS.common.response;

public class CommonResponse <T>{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
