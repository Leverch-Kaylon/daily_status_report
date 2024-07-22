package com.dsr.dtos;

public class DSRResponse {
    private boolean Status;
    private String SuccessMessage;
    private String ErrorMessage;

    public DSRResponse() {
    }

    public DSRResponse(boolean status, String successMessage, String errorMessage) {
        this.Status = status;
        this.SuccessMessage = successMessage;
        this.ErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.ErrorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return SuccessMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.SuccessMessage = successMessage;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }
}
