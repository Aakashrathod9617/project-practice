package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.OwnerDaoInt;
import com.rays.dto.OwnerDTO;

@Service
@Transactional
public class OwnerServiceImpl extends BaseServiceImpl<OwnerDTO, OwnerDaoInt> implements OwnerServiceInt {

}
