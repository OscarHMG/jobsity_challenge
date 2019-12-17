package com.backend.jobsity_challenge.views;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputChannel implements OutputChannel {

    @Override
    public void print(String string) {
        System.out.print(string);
    }
}
