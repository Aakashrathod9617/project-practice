package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.OwnerDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class OwnerForm extends BaseForm {

    @NotNull(message = "Please enter name")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Please enter date of birth")
    @ValidDate(message = "Invalid date format or value")
    private String dateOfBirth;

    @NotNull(message = "Please enter vehicle ID")
    @NotEmpty(message = "Vehicle ID cannot be empty")
    private String vehicleId;

    @NotNull(message = "Please enter insurance amount")
    @ValidLong(message = "Invalid input for insurance amount")
    private String insuranceAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    @Override
    public BaseDTO getDto() {
        OwnerDTO dto = initDTO(new OwnerDTO());

        dto.setName(name);

        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(dateOfBirth);
                dto.setDateOfBirth(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (vehicleId != null && !vehicleId.isEmpty()) {
            dto.setVehicleId(Long.valueOf(vehicleId));
        }

        if (insuranceAmount != null && !insuranceAmount.isEmpty()) {
            dto.setInsuranceAmount(Long.valueOf(insuranceAmount));
        }

        return dto;
    }
}
