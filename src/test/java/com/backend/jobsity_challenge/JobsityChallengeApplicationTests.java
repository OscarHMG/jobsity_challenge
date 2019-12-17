package com.backend.jobsity_challenge;

import com.backend.jobsity_challenge.controller.OutputController;
import com.backend.jobsity_challenge.controller.ScoringController;
import com.backend.jobsity_challenge.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
@Profile("test")
public class JobsityChallengeApplicationTests {

	@Autowired
	private OutputController outputController;

	@Autowired
	private ParseService parseService;

	@Autowired
	private ScoringController scoringController;

	@Autowired
	private Scanner scanner;

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	public static void main(String[] args) {
		SpringApplication.run(JobsityChallengeApplicationTests.class);
	}
}
