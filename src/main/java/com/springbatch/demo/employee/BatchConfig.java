package com.springbatch.demo.employee;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.demo.domain.Employee;
import com.springbatch.demo.domain.EmployeeEntity;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		// @formatter:off
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.flow(orderStep1())
				.end().build();
		// @formatter:on
	}

	@Bean
	public Step orderStep1() {
		// @formatter:off
		return stepBuilderFactory.get("orderStep1").<Employee, EmployeeEntity>chunk(10)
				.reader(new EmployeeReader())
				.processor(new EmployeeProcess())
				.writer(new EmployeeWriter())
				.build();
		// @formatter:on
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}
