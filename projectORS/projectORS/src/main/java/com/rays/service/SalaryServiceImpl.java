package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SalaryDaoInt;

import com.rays.dto.SalaryDTO;

@Service
@Transactional
public class SalaryServiceImpl extends BaseServiceImpl<SalaryDTO, SalaryDaoInt> implements SalaryServiceInt {

}
