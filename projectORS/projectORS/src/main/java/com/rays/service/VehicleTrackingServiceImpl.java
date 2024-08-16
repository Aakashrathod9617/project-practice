package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.VehicleTrackingDaoInt;
import com.rays.dto.VehicleTrackingDTO;

@Service
@Transactional
public class VehicleTrackingServiceImpl extends BaseServiceImpl<VehicleTrackingDTO, VehicleTrackingDaoInt> implements VehicleTrackingServiceInt{

}
