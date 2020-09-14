package com.springbatch.demo.employee;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;

import com.springbatch.demo.domain.Employee;
import com.springbatch.demo.domain.EmployeeEntity;

public class EmployeeProcess implements ItemProcessor<Employee, EmployeeEntity> {

	@Override
	public EmployeeEntity process(Employee employee) throws Exception {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, empEntity);
		return empEntity;
	}

}
