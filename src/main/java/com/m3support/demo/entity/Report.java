package com.m3support.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report_transactional")
@IdClass(ReportId.class)
public class Report {

	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account_id;

	@Id
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project_id;

	@Id
	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
	private Employee emp_id;

	@Lob
	@Column(name = "task_completed")
	private String task_completed;

	@Lob
	@Column(name = "task_planned")
	private String task_planned;

	@Lob
	@Column(name = "task_issues")
	private String task_issues;

	@Id
	@Column(name = "submission_date")
	private Date submissionDate;

	public Report() {

	}

	public Report(Account account_id, Project project_id, Employee emp_id, String task_completed, String task_planned,
			String task_issues, Date submissionDate) {
		this.account_id = account_id;
		this.project_id = project_id;
		this.emp_id = emp_id;
		this.task_completed = task_completed;
		this.task_planned = task_planned;
		this.task_issues = task_issues;
		this.submissionDate = submissionDate;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	public Project getProject_id() {
		return project_id;
	}

	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}

	public Employee getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
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

	public Date getSubmissionDate() {

		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	@Override
	public String toString() {
		return "Report [account_id=" + account_id + ", project_id=" + project_id + ", emp_id=" + emp_id
				+ ", task_completed=" + task_completed + ", task_planned=" + task_planned + ", task_issues="
				+ task_issues + ", submissionDate=" + submissionDate + "]";
			}

}
