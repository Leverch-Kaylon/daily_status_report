package com.dsr.dtos;

import com.dsr.entity.Employee;

import javax.persistence.Column;
import java.util.Date;

public class ReportDTO {
    private String task_completed;
    private String task_planned;

    private String task_issues;

    private Date submissionDate;

    private Employee emp_id;

    public Employee getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Employee emp_id) {
        this.emp_id = emp_id;
    }


    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }



    public String getTask_completed() {
        return task_completed;
    }

    public void setTask_completed(String task_completed) {
        this.task_completed = task_completed;
    }

    public String getTask_planned() {
        return task_planned;
    }

    public void setTask_planned(String task_planned) {
        this.task_planned = task_planned;
    }

    public String getTask_issues() {
        return task_issues;
    }

    public void setTask_issues(String task_issues) {
        this.task_issues = task_issues;
    }

}
