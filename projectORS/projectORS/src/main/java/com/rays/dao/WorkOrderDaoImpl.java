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
import com.rays.dto.WorkOrderDTO;

@Repository
public class WorkOrderDaoImpl extends BaseDAOImpl<WorkOrderDTO> implements WorkOrderDaoInt{
	
	
	@Override
	public Class<WorkOrderDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return WorkOrderDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(WorkOrderDTO dto, CriteriaBuilder builder, Root<WorkOrderDTO> qRoot) {
		// Create where conditions
				List<Predicate> whereCondition = new ArrayList<Predicate>();

				if (!isEmptyString(dto.getEqName())) {

					whereCondition.add(builder.like(qRoot.get("eqname"), dto.getEqName() + "%"));
				}
				if (!isEmptyString(dto.getDiscription())) {

					whereCondition.add(builder.like(qRoot.get("discription"), dto.getDiscription() + "%"));
				}

				if (dto.getWorkingDate() != null) {
					Date searchDate = dto.getWorkingDate();

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

					Predicate datePredicate = builder.between(qRoot.get("workingDate"), startDate, endDate);
					whereCondition.add(datePredicate);
				if (!isEmptyString(dto.getItem())) {

					whereCondition.add(builder.like(qRoot.get("item"), dto.getItem()));
				}
				
				if (!isZeroNumber(dto.getId())) {

					whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
				}
				
				if (!isZeroNumber(dto.getFrequency())) {

					whereCondition.add(builder.equal(qRoot.get("frequency"), dto.getFrequency()));
				}

				
			}
				return whereCondition;

	}
	
	}
