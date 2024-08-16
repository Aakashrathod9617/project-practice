package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VehicleTrackingDTO;
import com.rays.validation.ValidDate;

public class VehicleTrackingForm extends BaseForm {

    @NotNull(message = "Please enter Latitude")
    @DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90.0")
    private Double lat;

    @NotNull(message = "Please enter Longitude")
    @DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180.0")
    private Double lon;

    @NotNull(message = "Please enter Vehicle ID")
    private String vehicleId;

    @NotNull(message = "Please enter Date")
    @ValidDate(message = "Invalid date format or value")
    private String date;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleID(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public BaseDTO getDto() {
        VehicleTrackingDTO dto = initDTO(new VehicleTrackingDTO());
        dto.setLat(lat);
        dto.setLon(lon);
        dto.setVehicleId(vehicleId);
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
