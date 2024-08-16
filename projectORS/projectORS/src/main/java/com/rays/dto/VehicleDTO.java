package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedHashMap;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_VEHICLE")
public class VehicleDTO extends BaseDTO {

    @Column(name = "NUMBER", length = 20)
    private String number;

    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;

    @Column(name = "INSURANCE_AMOUNT")
    private Long insuranceAmount;

    @Column(name = "COLOUR", length = 30)
    private String colour;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Long insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String getValue() {
        // Assuming product or another relevant attribute is appropriate here
        return colour;
    }

    @Override
    public String getUniqueKey() {
        // Assuming amount or another relevant attribute is appropriate here
        return "number";
    }

    @Override
    public String getUniqueValue() {
        // Assuming amount or another relevant attribute is appropriate here
        return number;
    }

    @Override
    public String getLabel() {
        // Assuming Id or another relevant attribute is appropriate here
        return "number";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
      LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
      map.put("number", "asc");
      return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
      LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
      map.put("number", number);
      return map;
    }
}
