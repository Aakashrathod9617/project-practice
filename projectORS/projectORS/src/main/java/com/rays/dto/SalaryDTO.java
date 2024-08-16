package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_SALARY")
public class SalaryDTO extends BaseDTO {

 
    @Column(name = "EMPLOYEE")
    private String employee;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "APPLIED_DATE")
    private Date appliedDate;

    @Column(name = "STATUS")
    private String status;

    // Getters and Setters

    
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 
    @Override
    public String getValue() {
        return employee;
    }

    @Override
    public String getUniqueKey() {
        return "id";
    }

    @Override
    public String getUniqueValue() {
        return id != null ? id.toString() : null;
    }

    @Override
    public String getLabel() {
        return "ID";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("employee", "asc");
        map.put("appliedDate", "desc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        return map;
    }
}
