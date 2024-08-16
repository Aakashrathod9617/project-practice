package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TransportationDaoInt;
import com.rays.dto.TransportationDTO;


@Service
@Transactional
public class TransportationServiceImpl extends BaseServiceImpl<TransportationDTO, TransportationDaoInt> implements TransportationServiceInt {

}
