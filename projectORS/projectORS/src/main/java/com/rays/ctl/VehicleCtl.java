package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.VehicleDTO;
import com.rays.form.VehicleForm;
import com.rays.service.VehicleServiceInt;

@RestController
@RequestMapping(value = "/Vehicle")
public class VehicleCtl extends BaseCtl<VehicleForm, VehicleDTO, VehicleServiceInt> {

    @Autowired
    private VehicleServiceInt vehicleService; // Assuming you have a VehicleService class

    @GetMapping("/preload")
    public ORSResponse preload() {
        System.out.println("Inside preload method");

        ORSResponse response = new ORSResponse(true);
        VehicleDTO dto = new VehicleDTO(); // Create a DTO object for search criteria if needed
        List<DropdownList> list = baseService.search(dto, 0, 5, userContext); // Use baseService to perform search
        response.addResult("vehicleList", list); // Add search results to the response

        return response;
    }
}

