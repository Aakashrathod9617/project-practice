package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.InventoryDTO;
import com.rays.dto.TransportationDTO;
import com.rays.form.TransportationForm;
import com.rays.service.TransportationServiceInt;


@RestController
@RequestMapping(value = "Trans")
public class TransportationCtl extends BaseCtl<TransportationForm, TransportationDTO, TransportationServiceInt>{

	
	private TransportationServiceInt ts;
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload Dipanshu");
	        ORSResponse res = new ORSResponse(true);
	        TransportationDTO dto = new TransportationDTO();
	        List<DropdownList> list = baseService.search(dto, 0, 5, userContext);
	        res.addResult("TransList", list);
	        return res;
	    }
	    
	}


