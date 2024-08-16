package com.rays.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;

@Service
@Transactional
public class EmployeServiceImpl extends BaseServiceImpl<EmployeeDTO, EmployeeDaoInt> implements EmployeServiceInt{

}
