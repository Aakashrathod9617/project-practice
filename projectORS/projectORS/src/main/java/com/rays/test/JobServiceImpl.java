package com.rays.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;

@Service
@Transactional
public class JobServiceImpl extends BaseServiceImpl<JobDTO, JobDaoInt> implements JobServiceInt{

}
