package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.exception.FileReadingException;
import com.backend.jobsity_challenge.model.Roll;
import com.backend.jobsity_challenge.validator.RollValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ParseServiceImpl implements ParseService {

    private static final int PLAYER_PART = 0;
    private static final int PINS_PART = 1;
    private static final String FILE_SCORE_SEPARATOR = "\t";

    @Autowired
    private RollValidator rollValidator;

    /**
     * The method parses a text file to get the registries of players and their roll scores
     * @param filePath the path to the file being parsed
     * @return a map where every player is the key and the values are the list of roll scores achieved
     */
    @Override
    public Map<String, List<Roll>> parse(String filePath) {
        Map<String, List<Roll>> rolls = new HashMap<>();

        try(Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> {
                String[] rollParts = splitPlayerNameFromScore(line);
                List<Roll> playerRolls = rolls.getOrDefault(rollParts[PLAYER_PART], new ArrayList<>());
                playerRolls.add(new Roll(rollValidator.validateRollValue(rollParts[PINS_PART])));
                rolls.put(rollParts[PLAYER_PART], playerRolls);
            });
        } catch (IOException e) {
            throw new FileReadingException("An error occurred while reading the file. Please verify the file path and extension.");
        }

        return rolls;
    }

    private String[] splitPlayerNameFromScore(String line) {
        return line.split(FILE_SCORE_SEPARATOR);
    }
}
