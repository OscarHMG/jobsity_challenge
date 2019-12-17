package com.backend.jobsity_challenge;

import com.backend.jobsity_challenge.controller.OutputController;
import com.backend.jobsity_challenge.controller.ScoringController;
import com.backend.jobsity_challenge.model.Player;
import com.backend.jobsity_challenge.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@Profile("!test")
public class ScoringApplication implements CommandLineRunner {

    @Autowired
    private OutputController outputController;

    @Autowired
    private ParseService parseService;

    @Autowired
    private ScoringController scoringController;

    @Autowired
    private Scanner scanner;

    @Override
    public void run(String... args) {
        main(args);
    }

    private void main(String[] args) {
        List<Player> gamePlayers = scoringController.calculateScores();
        outputController.printScore(gamePlayers);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
