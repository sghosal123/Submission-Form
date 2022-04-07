package com.example.SubmissionFormsRESTAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SubmissionFormsRestapiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SubmissionFormsRestapiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SubmissionFormsRestapiApplication.class, args);
	}

}
