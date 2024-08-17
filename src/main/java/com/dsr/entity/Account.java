package com.dsr.entity;

import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "account_master")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int account_id;

	@Column(name = "account_desc")
	private String account_desc;

	@Column(name = "deleted")
	private boolean deleted = false;

	@Column(name = "created_on")
	private Date created_on;

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "modified_on")
	private Date modified_on;

	@Column(name = "modified_by")
	private String modified_by;

	// Account default constructor
	public Account() {

	}

	public Account(int account_id, String account_desc, boolean deleted, Date created_on, String created_by,
			Date modified_on, String modified_by) {
		this.account_id = account_id;
		this.account_desc = account_desc;
		this.deleted = deleted;
		this.created_on = created_on;
		this.created_by = created_by;
		this.modified_on = modified_on;
		this.modified_by = modified_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount_desc() {
		return account_desc;
	}

	public void setAccount_desc(String account_desc) {
		this.account_desc = account_desc;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedOn() {
		return created_on;
	}

	public void setCreatedOn(Date created_on) {
		this.created_on = created_on;
	}

	public String getCreatedBy() {
		return created_by;
	}

	public void setCreatedBy(String created_by) {
		this.created_by = created_by;
	}

	public Date getModifiedOn() {
		return modified_on;
	}

	public void setModifiedOn(Date modified_on) {
		this.modified_on = modified_on;
	}


	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_desc=" + account_desc + ", deleted=" + deleted
				+ ", 						created_on=" + created_on + ", created_by=" + created_by + ", modified_on="
				+ modified_on + ", modified_by=" + modified_by + "]";
	}

}
