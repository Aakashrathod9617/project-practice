package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "VEHICLE_TRACKING")
public class VehicleTrackingDTO extends BaseDTO {

    @Column(name = "LAT")
    private Double lat;

    @Column(name = "LON")
    private Double lon;

    @Column(name = "VEHICLE_ID",length = 50)
    private String vehicleId;

    @Column(name = "TRACKING_DATE")
    private Date date;

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

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getValue() {
        return vehicleId;
    }

    @Override
    public String getUniqueKey() {
        return "vehicleId";
    }

    @Override
    public String getUniqueValue() {
        return vehicleId;
    }

    @Override
    public String getLabel() {
        return "vehicleId";
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("vehicleId", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("vehicleId", vehicleId);
        return map;
    }
}
