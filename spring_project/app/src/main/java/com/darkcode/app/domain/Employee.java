package com.darkcode.app.domain;

import lombok.Data;

@Data
public class Employee {
    private String fullname = "";
    private String user_email = "";

    public Employee() {
    }

    public Employee(String fullname, String user_email) {
        this.fullname = fullname;
        this.user_email = user_email;
    }

    public void setUser_email(String user_email){
        this.user_email = user_email;
    }

    public void setFullname(String name){
        this.fullname = name;
    }
    
}


