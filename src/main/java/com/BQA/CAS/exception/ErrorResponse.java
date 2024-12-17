package com.BQA.CAS.exception;

public class ErrorResponse {

    private String message;
    private int status;
    private String error;
    private Long timestamp;

    // Constructor
    public ErrorResponse(String message, int status, String error, Long timestamp) {
        this.message = message;
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
