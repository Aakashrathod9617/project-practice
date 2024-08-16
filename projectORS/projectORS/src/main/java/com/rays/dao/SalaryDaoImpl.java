package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.SalaryDTO;

@Repository
public class SalaryDaoImpl extends BaseDAOImpl<SalaryDTO> implements SalaryDaoInt{

	@Override
	protected List<Predicate> getWhereClause(SalaryDTO dto, CriteriaBuilder builder, Root<SalaryDTO> qRoot) {
		 List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getEmployee() != null && !dto.getEmployee().isEmpty()) {
	            whereCondition.add(builder.equal(qRoot.get("employee"), dto.getEmployee()));
	        }

	        if (dto.getAmount() != null && dto.getAmount() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("amount"), dto.getAmount()));
	        }

	        if (dto.getAppliedDate() != null) {
	            Date searchDate = dto.getAppliedDate();

	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(searchDate);
	            calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
	            calendar.set(Calendar.MINUTE, 0);
	            calendar.set(Calendar.SECOND, 0);
	            Date startDate = calendar.getTime();

	            calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
	            calendar.set(Calendar.MINUTE, 59);
	            calendar.set(Calendar.SECOND, 59);
	            Date endDate = calendar.getTime();

	            Predicate datePredicate = builder.between(qRoot.get("appliedDate"), startDate, endDate);
	            whereCondition.add(datePredicate);
	        }

	        if (dto.getStatus() != null && !dto.getStatus().isEmpty()) {
	            whereCondition.add(builder.equal(qRoot.get("status"), dto.getStatus()));
	        }

	        return whereCondition;
	    }

	@Override
	public Class<SalaryDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return SalaryDTO.class;
	}

}
