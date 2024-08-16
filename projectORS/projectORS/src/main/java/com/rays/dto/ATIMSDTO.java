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
@Table(name = "st_ATIMS")
public class ATIMSDTO extends BaseDTO {


    @Column(name = "LOCATION")
    private String location;

    @Column(name = "CASH_AVAILABLE")
    private Double cashAvailable;

    @Column(name = "LAST_RESTOCKED_DATE")
    private Date lastRestockedDate;

    @Column(name = "REMARK")
    private String remark;

    // Getters and Setters

 

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(Double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public Date getLastRestockedDate() {
        return lastRestockedDate;
    }

    public void setLastRestockedDate(Date lastRestockedDate) {
        this.lastRestockedDate = lastRestockedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getValue() {
        return location;
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
        map.put("location", "asc");
        map.put("lastRestockedDate", "desc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        return map;
    }
}
