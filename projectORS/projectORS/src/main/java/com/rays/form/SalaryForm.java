package com.rays.form;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SalaryDTO;
import com.rays.validation.ValidDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryForm extends BaseForm {

    @NotNull(message = "Please enter Amount")
    @DecimalMin(value = "0.0", inclusive = false, message = "Cost must be greater than 0")
    @DecimalMax(value = "200000", message = "Cost must be less than or equal to 200000")
    private String amount;

    @NotNull(message = "Please select Employee")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Description must contain only characters and spaces")
    private String employee;

    @NotNull(message = "Please enter Applied Date")
    @ValidDate(message = "Invalid date format or value")
    private String appliedDate;

    @NotNull(message = "Please select Status")
    private String status;

    // Getters and Setters

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public BaseDTO getDto() {
        SalaryDTO dto = initDTO(new SalaryDTO());
        if (amount != null && !amount.isEmpty()) {
            dto.setAmount(Double.valueOf(amount));
        }
        dto.setEmployee(employee);
        if (appliedDate != null && !appliedDate.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(appliedDate);
                dto.setAppliedDate(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        dto.setStatus(status);
        return dto;
    }
}
