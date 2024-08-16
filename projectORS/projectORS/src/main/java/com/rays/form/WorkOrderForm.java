package com.rays.form;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InventoryDTO;
import com.rays.dto.WorkOrderDTO;
import com.rays.validation.ValidAlphabetic;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class WorkOrderForm extends BaseForm{
	
	
	 @NotEmpty(message = "Please enter eqName")
	   @ValidAlphabetic(message = "Please enter alphabetic characters only")
	private String eqName;
	
	 @NotEmpty(message = "Please enter discription")
	 @ValidAlphabetic(message = "please enter Alphabet")
	private String discription;
	
	 @NotNull(message = "Please enter workingDate")
	  @ValidDate(message = "Invalid date format or value")
	private String workingDate;
	
	 @NotEmpty(message = "Please enter item")
	    @ValidAlphabetic(message = "please enter Alphabet")
	private String item;
	
	
	 @NotNull(message = "Please enter frequency")
	    @ValidLong(message = "Invalid input for frequency")
	private String frequency;


	public String getEqName() {
		return eqName;
	}


	public void setEqName(String eqName) {
		this.eqName = eqName;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public String getWorkingDate() {
		return workingDate;
	}


	public void setWorkingDate(String workingDate) {
		this.workingDate = workingDate;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	

    @Override
    public BaseDTO getDto() {
        WorkOrderDTO dto = initDTO(new WorkOrderDTO());
        
        dto.setEqName(eqName);
        dto.setDiscription(discription);
        if (workingDate != null && !(workingDate).isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDate = dateFormat.parse(workingDate);
                dto.setWorkingDate(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        dto.setItem(item);
        if (frequency != null && !frequency.isEmpty()) {
            dto.setFrequency(Long.valueOf(frequency));
        }
        return dto;
    }

}
