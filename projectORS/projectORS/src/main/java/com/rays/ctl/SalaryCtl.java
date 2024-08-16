package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.SalaryDTO;

import com.rays.form.SalaryForm;

import com.rays.service.SalaryServiceInt;
import com.rays.test.EmployeServiceInt;
import com.rays.test.EmployeeDTO;



@RestController
@RequestMapping(value = "Salary")
public class SalaryCtl extends BaseCtl<SalaryForm, SalaryDTO, SalaryServiceInt>{

	
	private SalaryServiceInt ts;
	
	@Autowired
	private EmployeServiceInt empl;
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload Dipanshu");
	        ORSResponse res = new ORSResponse(true);
	        SalaryDTO dto = new SalaryDTO();
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