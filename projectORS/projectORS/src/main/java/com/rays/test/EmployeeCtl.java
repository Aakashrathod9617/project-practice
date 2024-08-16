package com.rays.test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;



@RestController
@RequestMapping(value = "Empl")
public class EmployeeCtl extends BaseCtl<EmployeeForm, EmployeeDTO, EmployeServiceInt>{

	private EmployeServiceInt empl;
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload Dipanshu");
	        ORSResponse res = new ORSResponse(true);
	        EmployeeDTO dto = new EmployeeDTO();
	        List<DropdownList> list = baseService.search(dto, 0, 5, userContext);
	        res.addResult("TransList", list);
	        return res;
	    }
}
