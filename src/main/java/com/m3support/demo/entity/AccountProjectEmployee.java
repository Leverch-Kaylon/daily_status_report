package com.m3support.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_project_employee_transactional")
@IdClass(AccountProjectEmployeeId.class)
public class AccountProjectEmployee {

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

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "modifiedOn")
	private Date modifiedOn;

	@Column(name = "modifiedBy")
	private String modifiedBy;

}
