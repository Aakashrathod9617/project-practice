package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VehicleDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class VehicleForm extends BaseForm {

    @NotNull(message = "Please enter number")
    private String number;

    @NotNull(message = "Please enter purchase date")
    @ValidDate(message = "Invalid date format or value")
    private String purchaseDate;

    @NotNull(message = "Please enter insurance amount")
	@ValidLong(message = "Invalid input for price")
    private String insuranceAmount;

    @NotEmpty(message = "Please enter colour")
    private String colour;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

 
    public BaseDTO getDto() {
        VehicleDTO dto = initDTO(new VehicleDTO());
        
        dto.setNumber(number);
        
        if (purchaseDate != null && !purchaseDate.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(purchaseDate);
                dto.setPurchaseDate(parsedDate);
            } catch (ParseException e) {
                // Handle parse exception if needed
                e.printStackTrace();
            }
        }
        
        if (insuranceAmount != null && !insuranceAmount.isEmpty()) {
            dto.setInsuranceAmount(Long.valueOf(insuranceAmount));
        }
        
        dto.setColour(colour);

        return dto;
    }
}
