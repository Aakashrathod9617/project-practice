package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TransportationDTO;
import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class TransportationForm extends BaseForm {

    @NotNull(message = "Please enter Cost")
    @DecimalMin(value = "0.0", inclusive = false, message = "Cost must be greater than 0")
    @DecimalMax(value = "200000", message = "Cost must be less than or equal to 200000")
    private String cost;

    @NotNull(message = "Please enter Description")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Description must contain only characters and spaces")
    private String description;

    @NotNull(message = "Please enter Mode")
    private String mode;

    @NotNull(message = "Please enter Date")
    @ValidDate(message = "Invalid date format or value")
    private String date;


    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public BaseDTO getDto() {
        TransportationDTO dto = initDTO(new TransportationDTO());
        if (cost != null && !cost.isEmpty()) {
            dto.setCost(Double.valueOf(cost));
        }
        dto.setDescription(description);
        dto.setMode(mode);
        if (date != null && !date.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(date);
                dto.setDate(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }
}
