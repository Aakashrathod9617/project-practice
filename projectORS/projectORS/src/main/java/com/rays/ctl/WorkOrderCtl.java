package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.InventoryDTO;
import com.rays.dto.WorkOrderDTO;
import com.rays.form.WorkOrderForm;

import com.rays.service.WorkOrderServiceInt;


@RestController
@RequestMapping(value = "Work")
public class WorkOrderCtl extends BaseCtl<WorkOrderForm, WorkOrderDTO, WorkOrderServiceInt> {
	
	
	@Autowired
	private WorkOrderServiceInt orderServiceInt;
	
	 @GetMapping("/preload")
	    public ORSResponse preload() {
	        System.out.println("Inside preload Dipanshu");
	        ORSResponse res = new ORSResponse(true);
	        WorkOrderDTO dto = new WorkOrderDTO();
	        List<DropdownList> list = baseService.search(dto, 0, 5, userContext);
	        res.addResult("workOrderList", list);
	        return res;
	    }


}
