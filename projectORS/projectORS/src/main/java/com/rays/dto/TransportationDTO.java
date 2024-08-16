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
@Table(name = "ST_TRANSPORTATION")
public class TransportationDTO extends BaseDTO {


    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Column(name = "MODE", length = 50)
    private String mode;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "COST")
    private Double cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

@Override
public String getKey() {
	// TODO Auto-generated method stub
	return id + "";
}
    @Override
    public String getValue() {
        return mode;
    }

    @Override
    public String getUniqueKey() {
        return "description";
    }

    @Override
    public String getUniqueValue() {
        return description;
    }

    @Override
    public String getLabel() {
        return "Id";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("cost", "asc");
        map.put("mode", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
    	LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("description", description);
        return map;
    }
}
