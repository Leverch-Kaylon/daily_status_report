package com.dsr.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account_project_employee_transactional")
@IdClass(AccountProjectEmployeeId.class)
public class AccountProjectEmployee {
	public AccountProjectEmployee(Account account_id, Employee emp_id,
								  Project project_id, boolean deleted,
								  Date createdOn, String createdBy, Date modifiedOn,
								  String modifiedBy) {
		this.account_id = account_id;
		this.emp_id = emp_id;
		this.project_id = project_id;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
	}
	 public AccountProjectEmployee(){}

	@Id
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account_id;

	@Id
	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
	private Employee emp_id;

	@Id
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project_id;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "createdOn")
	private Date createdOn;

	@NotBlank
	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "modifiedOn")
	private Date modifiedOn;

	@Column(name = "modifiedBy")
	private String modifiedBy;


	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	public Employee getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
	}

	public Project getProject_id() {
		return project_id;
	}

	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
