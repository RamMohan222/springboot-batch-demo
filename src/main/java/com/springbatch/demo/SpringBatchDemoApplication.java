package com.springbatch.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springbatch.demo.employee.EmployeeJobRunner;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchDemoApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(SpringBatchDemoApplication.class, args);
		context.getBean(EmployeeJobRunner.class).run();
	}

}
