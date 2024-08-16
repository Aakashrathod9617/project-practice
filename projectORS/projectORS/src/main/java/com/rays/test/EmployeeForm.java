package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;

import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;

public class EmployeeForm extends BaseForm {

  
    @NotNull(message = "Please enter Name")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only characters and spaces")
    private String name;

    @NotNull(message = "Please enter Date")
    @ValidDate(message = "Invalid date format or value")
    private String dateOfJoining;

    @NotNull(message = "Please enter Department")
    private String department;

    @NotNull(message = "Please enter Last Employer Name")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Last Employer Name must contain only characters and spaces")
    private String lastEmployerName;

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
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
    public BaseDTO getDto() {
        EmployeeDTO dto = initDTO(new EmployeeDTO());
      
        dto.setName(name);
        dto.setDepartment(department);
        dto.setLastEmployerName(lastEmployerName);
        if (dateOfJoining != null && !dateOfJoining.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(dateOfJoining);
                dto.setDateOfJoining(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }
}
