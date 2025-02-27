
package com.dsr.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@DynamicUpdate
@Table(name = "project_master")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int project_id;

	@NotBlank
	@Column(name = "project_desc")
	private String project_desc;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "reporting_manager", referencedColumnName = "emp_id")
	private Employee reporting_manager;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account_id;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "created_on")
	private LocalDate created_on;

	@NotBlank
	@Column(name = "created_by")
	private String created_by;

	@Column(name = "modified_on")
	private LocalDate modified_on;

	@Column(name = "modified_by")
	private String modified_by;

	// Account default constructor
	public Project() {

	}

	public Project(int project_id, String project_desc, Employee reporting_manager, Account account_id,
			boolean deleted, LocalDate created_on, String created_by, LocalDate modified_on, String modified_by) {
		this.project_id = project_id;
		this.project_desc = project_desc;
		this.reporting_manager = reporting_manager;
		this.account_id = account_id;
		this.deleted = deleted;
		this.created_on = created_on;
		this.created_by = created_by;
		this.modified_on = modified_on;
		this.modified_by = modified_by;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public Employee getReporting_manager() {
		return reporting_manager;
	}

	public void setReporting_manager(Employee reporting_manager) {
		this.reporting_manager = reporting_manager;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LocalDate getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDate created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public LocalDate getModified_on() {
		return modified_on;
	}

	public void setModified_on(LocalDate modified_on) {
		this.modified_on = modified_on;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Account getAccount_master() {
		return account_id;
	}

	public void setAccount_master(Account account_id) {

		this.account_id = account_id;
	}

	public void setReportingManager_master(Employee employee_master) {

		this.reporting_manager = employee_master;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_desc=" + project_desc + ", reporting_manager="
				+ reporting_manager + ", account_id=" + account_id + ", deleted=" + deleted + ", created_on="
				+ created_on + ", created_by=" + created_by + ", modified_on=" + modified_on + ", modified_by="
				+ modified_by + "]";
	}

}
