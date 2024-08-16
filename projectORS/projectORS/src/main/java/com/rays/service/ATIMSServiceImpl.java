package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ATIMSDaoInt;
import com.rays.dto.ATIMSDTO;


@Service
@Transactional
public class ATIMSServiceImpl extends BaseServiceImpl<ATIMSDTO, ATIMSDaoInt> implements ATIMSServiceInt{

}
