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
import com.rays.dto.ATIMSDTO;


@Repository
public class ATIMSDaoImpl extends BaseDAOImpl<ATIMSDTO> implements ATIMSDaoInt{

	@Override
	protected List<Predicate> getWhereClause(ATIMSDTO dto, CriteriaBuilder builder, Root<ATIMSDTO> qRoot) {
		  List<Predicate> whereCondition = new ArrayList<>();

		    if (dto.getId() != null && dto.getId() > 0) {
		        whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		    }

		    if (dto.getLocation() != null && !dto.getLocation().isEmpty()) {
		        whereCondition.add(builder.equal(qRoot.get("location"), dto.getLocation()));
		    }

		    if (dto.getCashAvailable() != null && dto.getCashAvailable() > 0) {
		        whereCondition.add(builder.equal(qRoot.get("cashAvailable"), dto.getCashAvailable()));
		    }

		    if (dto.getLastRestockedDate() != null) {
		        Date searchDate = dto.getLastRestockedDate();

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

		        Predicate datePredicate = builder.between(qRoot.get("lastRestockedDate"), startDate, endDate);
		        whereCondition.add(datePredicate);
		    }

		    if (dto.getRemark() != null && !dto.getRemark().isEmpty()) {
		        whereCondition.add(builder.equal(qRoot.get("remark"), dto.getRemark()));
		    }

		    return whereCondition;
		}

	@Override
	public Class<ATIMSDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ATIMSDTO.class;
	}

}
