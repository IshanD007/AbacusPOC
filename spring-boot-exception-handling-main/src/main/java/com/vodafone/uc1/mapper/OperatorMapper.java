package com.vodafone.uc1.mapper;

import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.dto.OperatorDto;

public interface OperatorMapper {
	public Operator getConvertFromDtoOperatorToEntityOperator(OperatorDto operatorDto);
	public OperatorDto getConvertFromEntityOperatorToDtoOperator(Operator operator);

}
