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

public class JobForm extends BaseForm {

    @NotNull(message = "Please enter Title")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Title must contain only characters and spaces")
    private String title;

    @NotNull(message = "Please enter Date of Opening")
    @ValidDate(message = "Invalid date format or value")
    private String dateOfOpening;

    @NotNull(message = "Please enter Experience")
    private String experience;

    @NotNull(message = "Please enter Status")
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(String dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public BaseDTO getDto() {
        JobDTO dto = initDTO(new JobDTO());

        dto.setTitle(title);
        dto.setExperience(experience);
        dto.setStatus(status);
        if (dateOfOpening != null && !dateOfOpening.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(dateOfOpening);
                dto.setDateOfOpening(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }
}
