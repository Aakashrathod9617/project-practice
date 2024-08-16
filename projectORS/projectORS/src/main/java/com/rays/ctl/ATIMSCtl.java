package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ATIMSDTO;
import com.rays.form.ATIMSForm;
import com.rays.service.ATIMSServiceInt;


@RestController
@RequestMapping(value = "ATIMS")
public class ATIMSCtl  extends BaseCtl<ATIMSForm, ATIMSDTO, ATIMSServiceInt>{

	
	private ATIMSServiceInt ts;
	
	
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload Dipanshu");
	        ORSResponse res = new ORSResponse(true);
	        ATIMSDTO dto = new ATIMSDTO();
	        List<DropdownList> list = baseService.search(dto, 0, 5, userContext);
	        res.addResult("TransList", list);
	        return res;
	    }
	
//	 @GetMapping("/preload")
//	    public ORSResponse preload() {
//	        System.out.println("Inside preload Dipanshu");
//	        ORSResponse res = new ORSResponse(true);
//	        EmployeeDTO dto = new EmployeeDTO();
//	        List<DropdownList> list = empl.search(dto, 0, 5, userContext);
//	        res.addResult("TransList", list);
//	        return res;
//	    }
	    
	}