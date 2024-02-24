package com.m3support.demo.dtos;

import java.util.Date;

public class ProjectDto {
	
    private int project_id;
    
    private String project_desc;
    
    private int account_id;
    
    private String account_desc;
        
    private Date modified_on;
    
    private String modified_by;
    
    private Date created_on;
    
    private String created_by;
    
    private boolean deleted;
    
    public ProjectDto() {
    	
    }

    

    public ProjectDto(int project_id, String project_desc, int account_id, String account_desc,
			Date modified_on, String modified_by, Date created_on, String created_by,
			boolean deleted) {
		this.project_id = project_id;
		this.project_desc = project_desc;
		this.account_id = account_id;
		this.account_desc = account_desc;
		this.modified_on = modified_on;
		this.modified_by = modified_by;
		this.created_on = created_on;
		this.created_by = created_by;
		this.deleted = deleted;
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

	public Date getModified_on() {
		return modified_on;
	}



	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}



	public String getModified_by() {
		return modified_by;
	}



	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}



	public Date getCreated_on() {
		return created_on;
	}



	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}



	public String getCreated_by() {
		return created_by;
	}



	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	
}