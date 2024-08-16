package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.OwnerDTO;
import com.rays.dto.VehicleDTO;
import com.rays.form.OwnerForm;
import com.rays.service.OwnerServiceInt;
import com.rays.service.VehicleServiceInt;


@RestController
@RequestMapping(value = "/Owner")
public class OwnerCtl extends BaseCtl<OwnerForm, OwnerDTO, OwnerServiceInt>{
	 @Autowired
	    private OwnerServiceInt ownerService; // Assuming you have a VehicleService class

	 @Autowired
	    private VehicleServiceInt vs;
	 
	    @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload method");

	        ORSResponse response = new ORSResponse(true);
	        VehicleDTO dto = new VehicleDTO(); // Create a DTO object for search criteria if needed
	        List<DropdownList> list = vs.search(dto, 0, 5, userContext); // Use baseService to perform search
	        response.addResult("ownerList", list); // Add search results to the response

	        return response;
	    }
	}