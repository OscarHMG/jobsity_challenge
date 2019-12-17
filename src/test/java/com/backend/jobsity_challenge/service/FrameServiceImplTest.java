package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Frame;
import com.backend.jobsity_challenge.model.Roll;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FrameServiceImplTest {

    private FrameService frameService;

    @Before
    public void setUp() {
        frameService = new FrameServiceImpl();
    }

    @Test
    public void createStandardGameFrames() {
        List<Roll> standardGameRolls = new ArrayList<>();
        standardGameRolls.add(new Roll("2"));
        standardGameRolls.add(new Roll("8"));

        standardGameRolls.add(new Roll("10"));

        standardGameRolls.add(new Roll("5"));
        standardGameRolls.add(new Roll("2"));

        standardGameRolls.add(new Roll("2"));
        standardGameRolls.add(new Roll("F"));

        standardGameRolls.add(new Roll("10"));

        standardGameRolls.add(new Roll("0"));
        standardGameRolls.add(new Roll("2"));

        standardGameRolls.add(new Roll("10"));

        standardGameRolls.add(new Roll("8"));
        standardGameRolls.add(new Roll("1"));

        standardGameRolls.add(new Roll("f"));
        standardGameRolls.add(new Roll("9"));

        standardGameRolls.add(new Roll("2"));
        standardGameRolls.add(new Roll("3"));

        List<Frame> gameFrames = frameService.createGameFrames(standardGameRolls);

        assertEquals(gameFrames.get(0).getScore(), 20);
        assertEquals(gameFrames.get(1).getScore(), 17);
        assertEquals(gameFrames.get(2).getScore(), 7);
        assertEquals(gameFrames.get(3).getScore(), 2);
        assertEquals(gameFrames.get(4).getScore(), 12);
        assertEquals(gameFrames.get(5).getScore(), 2);
        assertEquals(gameFrames.get(6).getScore(), 19);
        assertEquals(gameFrames.get(7).getScore(), 9);
        assertEquals(gameFrames.get(8).getScore(), 9);
        assertEquals(gameFrames.get(9).getScore(), 5);
    }

    @Test
    public void createPerfectGameFrames() {
        List<Roll> perfectGameRolls = new ArrayList<>();

        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));
        perfectGameRolls.add(new Roll("10"));

        List<Frame> gameFrames = frameService.createGameFrames(perfectGameRolls);

        assertEquals(gameFrames.get(0).getScore(), 30);
        assertEquals(gameFrames.get(1).getScore(), 30);
        assertEquals(gameFrames.get(2).getScore(), 30);
        assertEquals(gameFrames.get(3).getScore(), 30);
        assertEquals(gameFrames.get(4).getScore(), 30);
        assertEquals(gameFrames.get(5).getScore(), 30);
        assertEquals(gameFrames.get(6).getScore(), 30);
        assertEquals(gameFrames.get(7).getScore(), 30);
        assertEquals(gameFrames.get(8).getScore(), 30);
        assertEquals(gameFrames.get(9).getScore(), 30);
    }

    @Test
    public void createPerfectGameWithSpareEnding() {
        List<Roll> almostPerfectGameRolls = new ArrayList<>();

        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("10"));
        almostPerfectGameRolls.add(new Roll("1"));
        almostPerfectGameRolls.add(new Roll("9"));
        almostPerfectGameRolls.add(new Roll("1"));

        List<Frame> gameFrames = frameService.createGameFrames(almostPerfectGameRolls);

        assertEquals(gameFrames.get(0).getScore(), 30);
        assertEquals(gameFrames.get(1).getScore(), 30);
        assertEquals(gameFrames.get(2).getScore(), 30);
        assertEquals(gameFrames.get(3).getScore(), 30);
        assertEquals(gameFrames.get(4).getScore(), 30);
        assertEquals(gameFrames.get(5).getScore(), 30);
        assertEquals(gameFrames.get(6).getScore(), 30);
        assertEquals(gameFrames.get(7).getScore(), 21);
        assertEquals(gameFrames.get(8).getScore(), 20);
        assertEquals(gameFrames.get(9).getScore(), 11);
    }

    @Test
    public void createDisasterGame() {
        List<Roll> disasterGameRolls = new ArrayList<>();

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));

        disasterGameRolls.add(new Roll("0"));
        disasterGameRolls.add(new Roll("0"));



        List<Frame> gameFrames = frameService.createGameFrames(disasterGameRolls);

        assertEquals(gameFrames.get(0).getScore(), 0);
        assertEquals(gameFrames.get(1).getScore(), 0);
        assertEquals(gameFrames.get(2).getScore(), 0);
        assertEquals(gameFrames.get(3).getScore(), 0);
        assertEquals(gameFrames.get(4).getScore(), 0);
        assertEquals(gameFrames.get(5).getScore(), 0);
        assertEquals(gameFrames.get(6).getScore(), 0);
        assertEquals(gameFrames.get(7).getScore(), 0);
        assertEquals(gameFrames.get(8).getScore(), 0);
        assertEquals(gameFrames.get(9).getScore(), 0);
    }
}