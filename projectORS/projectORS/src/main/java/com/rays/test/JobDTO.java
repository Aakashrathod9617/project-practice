package com.rays.test;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_JOB")
public class JobDTO extends BaseDTO {

    @Column(name = "TITLE", length = 100)
    private String title;

    @Column(name = "DATE_OF_OPENING")
    private Date dateOfOpening;

    @Column(name = "EXPERIENCE", length = 50)
    private String experience;

    @Column(name = "STATUS", length = 20)
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(Date dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getKey() {
        return id + "";
    }

    @Override
    public String getValue() {
        return status;
    }

    @Override
    public String getUniqueKey() {
        return "title";
    }

    @Override
    public String getUniqueValue() {
        return title;
    }

    @Override
    public String getLabel() {
        return "Id";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("title", "asc");
        map.put("dateOfOpening", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("title", title);
        return map;
    }
}
