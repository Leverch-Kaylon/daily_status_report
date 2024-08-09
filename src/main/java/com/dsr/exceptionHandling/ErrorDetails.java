package com.dsr.exceptionHandling;

import java.time.LocalDateTime;

public class ErrorDetails {

    public ErrorDetails(int code, String title, String message) {
        this.code = code;
        this.title = title;
        this.message = message;
    }

    private LocalDateTime timestamp;
    private int code;
    private String title;
    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
