package com.rays.test;

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
@Table(name = "ST_EMPLOYEE")
public class EmployeeDTO extends BaseDTO {

 

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DATE_OF_JOINING")
    private Date dateOfJoining;

    @Column(name = "DEPARTMENT", length = 50)
    private String department;

    @Column(name = "LAST_EMPLOYER_NAME", length = 100)
    private String lastEmployerName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLastEmployerName() {
        return lastEmployerName;
    }

    public void setLastEmployerName(String lastEmployerName) {
        this.lastEmployerName = lastEmployerName;
    }

    @Override
    public String getKey() {
        return id + "";
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public String getUniqueKey() {
        return "name";
    }

    @Override
    public String getUniqueValue() {
        return name;
    }

    @Override
    public String getLabel() {
        return "Id";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "asc");
        map.put("department", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("name", name);
        return map;
    }
}
