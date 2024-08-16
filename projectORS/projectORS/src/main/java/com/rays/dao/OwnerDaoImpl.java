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
import com.rays.dto.OwnerDTO;

@Repository
public class OwnerDaoImpl extends BaseDAOImpl<OwnerDTO> implements OwnerDaoInt {

    @Override
    protected List<Predicate> getWhereClause(OwnerDTO dto, CriteriaBuilder builder, Root<OwnerDTO> qRoot) {
        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getName() != null && !dto.getName().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }

        if (dto.getDateOfBirth() != null) {
			Date searchDate = dto.getDateOfBirth();

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

			Predicate datePredicate = builder.between(qRoot.get("dateOfBirth"), startDate, endDate);
			whereCondition.add(datePredicate);
		}


        if (dto.getVehicleId() != null) {
            whereCondition.add(builder.equal(qRoot.get("vehicleId"), dto.getVehicleId()));
        }

        if (dto.getInsuranceAmount() != null) {
            whereCondition.add(builder.equal(qRoot.get("insuranceAmount"), dto.getInsuranceAmount()));
        }

        if (dto.getId() != null) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        return whereCondition;
    }

    @Override
    public Class<OwnerDTO> getDTOClass() {
        return OwnerDTO.class;
    }
}
