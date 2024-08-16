package com.rays.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;

@Repository
public class EmployeeDaoImpl  extends BaseDAOImpl<EmployeeDTO> implements EmployeeDaoInt{

	@Override
	protected List<Predicate> getWhereClause(EmployeeDTO dto, CriteriaBuilder builder, Root<EmployeeDTO> qRoot) {
		  List<Predicate> whereCondition = new ArrayList<>();

		    if (dto.getId() != null && dto.getId() > 0) {
		        whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		    }

		    if (dto.getName() != null && !dto.getName().isEmpty()) {
		        whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		    }

		    if (dto.getDateOfJoining() != null) {
		        Date searchDate = dto.getDateOfJoining();

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

		        Predicate datePredicate = builder.between(qRoot.get("dateOfJoining"), startDate, endDate);
		        whereCondition.add(datePredicate);
		    }

		    if (dto.getDepartment() != null && !dto.getDepartment().isEmpty()) {
		        whereCondition.add(builder.equal(qRoot.get("department"), dto.getDepartment()));
		    }

		    if (dto.getLastEmployerName() != null && !dto.getLastEmployerName().isEmpty()) {
		        whereCondition.add(builder.like(qRoot.get("lastEmployerName"), dto.getLastEmployerName() + "%"));
		    }

		    return whereCondition;
		}
	

	@Override
	public Class<EmployeeDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return EmployeeDTO.class;
	}

}
