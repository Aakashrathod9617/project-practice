package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.TransportationDTO;
import com.rays.dto.VehicleTrackingDTO;
import com.rays.form.TransportationForm;
import com.rays.form.VehicleTrackingForm;
import com.rays.service.TransportationServiceInt;
import com.rays.service.VehicleTrackingServiceInt;

@RestController
@RequestMapping(value = "Tracking")
public class VehicleTrackingCtl extends BaseCtl<VehicleTrackingForm, VehicleTrackingDTO, VehicleTrackingServiceInt>{

	
	private VehicleTrackingServiceInt vt;
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload Dipanshu");
	        ORSResponse res = new ORSResponse(true);
	        VehicleTrackingDTO dto = new VehicleTrackingDTO();
	        List<DropdownList> list = baseService.search(dto, 0, 5, userContext);
	        res.addResult("VehicleList", list);
	        return res;
	    }
	    
	}