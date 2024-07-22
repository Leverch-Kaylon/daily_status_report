package com.dsr.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.sql.Date;

public class EmployeeDto {
        private int emp_id;
        private int emp_psid;
        private String emp_firstname;
        private String emp_email;
        private String emp_role;
        private boolean deleted = false;
        private Date created_on;
        private String created_by;

        private Date modified_on;

        private String modified_by;

	public EmployeeDto() {
        }

	public EmployeeDto(int emp_id, int emp_psid, String emp_firstname, String emp_email, String emp_role, boolean deleted,
        Date created_on, String created_by, Date modified_on, String modified_by) {

            this.emp_id = emp_id;
            this.emp_psid = emp_psid;
            this.emp_firstname = emp_firstname;
            this.emp_email = emp_email;
            this.emp_role = emp_role;
            this.deleted = deleted;
            this.created_on = created_on;
            this.created_by = created_by;
            this.modified_on = modified_on;
            this.modified_by = modified_by;
        }




        public int getEmp_id() {
            return emp_id;
        }


        public void setEmp_id(int emp_id) {
            this.emp_id = emp_id;
        }


        public int getEmp_psid() {
            return emp_psid;
        }

        public void setEmp_psid(int emp_psid) {
            this.emp_psid = emp_psid;
        }


        public String getEmp_firstname() {
            return emp_firstname;
        }

        public void setEmp_firstname(String emp_firstname) {
            this.emp_firstname = emp_firstname;
        }


        public String getEmp_email() {
            return emp_email;
        }


        public void setEmp_email(String emp_email) {
            this.emp_email = emp_email;
        }


        public String getEmp_role() {
            return emp_role;
        }


        public void setEmp_role(String emp_role) {
            this.emp_role = emp_role;
        }


        public boolean isDeleted() {
            return deleted;
        }


        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
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

        @Override
        public String toString() {
            return "Employee [emp_id=" + emp_id + ", emp_psid=" + emp_psid + ", emp_firstname=" + emp_firstname
                    + ", emp_email=" + emp_email + ", emp_role=" + emp_role + ", deleted=" + deleted + ", created_on="
                    + created_on + ", created_by=" + created_by + ", modified_on=" + modified_on + ", modified_by="
                    + modified_by + "]";
        }






    }
