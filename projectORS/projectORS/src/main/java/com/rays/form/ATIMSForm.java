package com.rays.form;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ATIMSDTO;
import com.rays.validation.ValidDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATIMSForm extends BaseForm {

    @NotNull(message = "Please enter Cash Available")
    @DecimalMax(value = "200000", message = "Cash cannot exceed 200,000")
    private String cashAvailable;

    @NotNull(message = "Please select Location")
    private String location;

    @NotNull(message = "Please enter Last Restocked Date")
    @ValidDate(message = "Invalid date format or value")
    private String lastRestockedDate;
    
 
    private String remark;

    // Getters and Setters

    public String getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(String cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLastRestockedDate() {
        return lastRestockedDate;
    }

    public void setLastRestockedDate(String lastRestockedDate) {
        this.lastRestockedDate = lastRestockedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public BaseDTO getDto() {
        ATIMSDTO dto = initDTO(new ATIMSDTO());
        if (cashAvailable != null && !cashAvailable.isEmpty()) {
            dto.setCashAvailable(Double.valueOf(cashAvailable));
        }
        dto.setLocation(location);
        if (lastRestockedDate != null && !lastRestockedDate.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(lastRestockedDate);
                dto.setLastRestockedDate(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        dto.setRemark(remark);
        return dto;
    }
}
