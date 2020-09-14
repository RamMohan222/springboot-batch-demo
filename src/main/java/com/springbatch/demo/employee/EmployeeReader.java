package com.springbatch.demo.employee;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.springbatch.demo.domain.Employee;

public class EmployeeReader implements ItemReader<Employee> {

	int count = 0;

	@Override
	public Employee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Employee employee = new Employee();
		employee.setFirstName("Ram");
		employee.setLastName("Mohan");
		employee.setId(count++);
		if (count > 100) {
			return null;
		}
		return employee;
	}

}
