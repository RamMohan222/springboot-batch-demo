package com.springbatch.demo.employee;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.springbatch.demo.domain.EmployeeEntity;

public class EmployeeWriter implements ItemWriter<EmployeeEntity> {

	@Override
	public void write(List<? extends EmployeeEntity> items) throws Exception {
		System.out.println("items:" + items.size());
		items.stream().forEach(System.out::println);
	}

}
