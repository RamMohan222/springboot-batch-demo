package com.springbatch.demo.employee;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeJobRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job processJob;

	public void run() throws Exception {
		// @formatter:off
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(processJob, jobParameters);
		// @formatter:on
	}

}
