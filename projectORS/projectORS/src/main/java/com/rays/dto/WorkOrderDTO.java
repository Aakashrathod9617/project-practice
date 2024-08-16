package com.rays.dto;


import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_WORK_ORDER")
public class WorkOrderDTO extends BaseDTO{
	
	@Column(name = "EQ_NAME", length = 50)
	private String eqName;
	
	@Column(name = "DISCRIPTION", length = 200)
	private String discription;
	
	@Column(name = "WORKING_DATE")
	private Date workingDate;
	
	@Column(name = "ITEM", length = 50)
	private String item;
	
	
	@Column(name = "FREQUENCY")
	private long frequency;


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


	public Date getWorkingDate() {
		return workingDate;
	}


	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public long getFrequency() {
		return frequency;
	}


	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}


	 @Override
	    public String getValue() {
	        return item;
	    }

	    @Override
	    public String getUniqueKey() {
	        return "eqName";
	    }

	    @Override
	    public String getUniqueValue() {
	        return eqName;
	    }

	    @Override
	    public String getLabel() {
	        return "Id";
	    }

	    @Override
	    public LinkedHashMap<String, String> orderBY() {
	        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	        map.put("item", "asc");
	        return map;
	    }

	    @Override
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
	        map.put("eqName", eqName);
	        return map;
	    }

	}
