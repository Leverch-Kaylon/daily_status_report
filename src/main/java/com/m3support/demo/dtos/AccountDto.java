package com.m3support.demo.dtos;

import java.util.Date;

public class AccountDto {
    private int AccountId;
    private String AccountName;
    private String ModifiedBy;
    private Date ModifiedOn;
    private String CreatedBy;
    private Date CreatedOn;
    private Boolean deleted;
    private String ReportingManager;
    private long ProjectsCount;
    private int ReportingManagerId;

    public AccountDto(int accountId, String accountName, String modifiedBy, Date modifiedOn, String createdBy,
            Date createdOn, Boolean deleted, long projectsCount, String reportingManager, int reportingManagerId) {
        this.AccountId = accountId;
        this.AccountName = accountName;
        this.ModifiedBy = modifiedBy;
        this.ModifiedOn = modifiedOn;
        this.ReportingManager = reportingManager;
        this.ProjectsCount = projectsCount;
        this.CreatedBy = createdBy;
        this.CreatedOn = createdOn;
        this.deleted = deleted;
        this.ReportingManagerId = reportingManagerId;
    }

    public int getReportingManagerId() {
        return ReportingManagerId;
    }

    public void setReportingManagerId(int reportingManagerId) {
        this.ReportingManagerId = reportingManagerId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.CreatedOn = createdOn;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        this.CreatedBy = createdBy;
    }

    public long getProjectsCount() {
        return ProjectsCount;
    }

    public void setProjectsCount(long projectsCount) {
        this.ProjectsCount = projectsCount;
    }

    public String getReportingManager() {
        return ReportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.ReportingManager = reportingManager;
    }

    public Date getModifiedOn() {
        return ModifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.ModifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.ModifiedBy = modifiedBy;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        this.AccountName = accountName;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        this.AccountId = accountId;
    }
}
