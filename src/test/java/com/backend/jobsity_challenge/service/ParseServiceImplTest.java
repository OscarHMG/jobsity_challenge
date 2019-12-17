package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.exception.FileReadingException;
import com.backend.jobsity_challenge.model.Roll;
import com.backend.jobsity_challenge.validator.RollValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ParseServiceImplTest {

    @Mock
    private RollValidator rollValidator;

    @InjectMocks
    private ParseServiceImpl parseService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(rollValidator.validateRollValue("10")).thenReturn("10");
        when(rollValidator.validateRollValue("7")).thenReturn("7");
        when(rollValidator.validateRollValue("3")).thenReturn("3");
    }

    @Test
    public void parseBasicFile() {

        List<Roll> jeffRolls = new ArrayList<>();
        List<Roll> johnRolls = new ArrayList<>();

        jeffRolls.add(new Roll("10"));
        jeffRolls.add(new Roll("7"));
        johnRolls.add(new Roll("3"));
        johnRolls.add(new Roll("7"));

        Map<String, List<Roll>> gamePlays = parseService.parse("src/test/resources/basic.txt");

        assertTrue(gamePlays.containsKey("Jeff"));
        assertTrue(gamePlays.containsKey("John"));

        assertTrue(gamePlays.get("Jeff").containsAll(jeffRolls));
        assertTrue(gamePlays.get("John").containsAll(johnRolls));
    }

    @Test(expected = FileReadingException.class)
    public void doNotParseOnWrongPath() {
        parseService.parse("basic.txt");
    }
}