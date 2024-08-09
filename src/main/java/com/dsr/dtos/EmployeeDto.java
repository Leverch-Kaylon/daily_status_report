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


	public EmployeeDto() {
        }

	public EmployeeDto(int emp_id, int emp_psid, String emp_firstname, String emp_email, String emp_role, boolean deleted,
        Date created_on, String created_by, Date modified_on, String modified_by) {

            this.emp_id = emp_id;
            this.emp_psid = emp_psid;
            this.emp_firstname = emp_firstname;
            this.emp_email = emp_email;
            this.emp_role = emp_role;

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

        @Override
        public String toString() {
            return "Employee [emp_id=" + emp_id + ", emp_psid=" + emp_psid + ", emp_firstname=" + emp_firstname
                    + ", emp_email=" + emp_email + ", emp_role=" + emp_role + "]";
        }






    }
