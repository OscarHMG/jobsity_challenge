package com.backend.jobsity_challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class InputServiceImpl implements InputService {

    @Autowired
    private Scanner scanner;

    @Override
    public String getInput() {
        System.out.println("\n\n");
        System.out.println("Please indicate the absolute path to your scoring file (i.e.: C:\\scores.txt): \n");
        return scanner.nextLine();
    }
}
