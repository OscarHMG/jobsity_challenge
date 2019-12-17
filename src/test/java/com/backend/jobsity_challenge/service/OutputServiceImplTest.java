package com.backend.jobsity_challenge.service;

import com.backend.jobsity_challenge.model.Frame;
import com.backend.jobsity_challenge.model.Roll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutputServiceImplTest {

    private OutputService outputService;

    @Before
    public void setUp() {
        outputService = new OutputServiceImpl();
    }

    @Test
    public void createMultiRollStrikeLine() {
        Frame frame = new Frame();
        Roll strike = new Roll("10");
        Roll secondBall = new Roll("2");
        Roll thirdBall = new Roll("8");

        frame.addRoll(strike);
        frame.addRoll(secondBall);
        frame.addRoll(thirdBall);

        String line = outputService.prepareMultiRollStrikeLine(frame);

        assertEquals("X\t2\t8", line);
    }

    @Test
    public void createSingleRollStrikeLine() {
        Frame frame = new Frame();
        Roll strike = new Roll("10");

        frame.addRoll(strike);

        String line = outputService.prepareSingleRollStrikeLine(frame);

        assertEquals("\tX\t", line);
    }

    @Test
    public void createSpareLine() {
        Frame frame = new Frame();
        Roll firstBall = new Roll("5");
        Roll secondBall = new Roll("5");

        frame.addRoll(firstBall);
        frame.addRoll(secondBall);

        String line = outputService.prepareSpareLine(frame);

        assertEquals("5\t/\t", line);
    }

    @Test
    public void createStandardLine() {
        Frame frame = new Frame();
        Roll firstBall = new Roll("5");
        Roll secondBall = new Roll("3");

        frame.addRoll(firstBall);
        frame.addRoll(secondBall);

        String line = outputService.prepareStandardLine(frame);

        assertEquals("5\t3\t", line);
    }
}