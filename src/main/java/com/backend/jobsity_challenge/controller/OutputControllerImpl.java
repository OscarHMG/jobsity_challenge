package com.backend.jobsity_challenge.controller;

import com.backend.jobsity_challenge.model.Frame;
import com.backend.jobsity_challenge.model.Player;
import com.backend.jobsity_challenge.service.OutputService;
import com.backend.jobsity_challenge.views.OutputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OutputControllerImpl implements OutputController {

    private static final String HEADER_ROW = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n";
    private static final String PINFALLS_COLUMN = "Pinfalls\t";
    private static final String SCORES_COLUMN = "Score\t\t";

    @Autowired
    private OutputService outputService;
    
    @Autowired
    private OutputChannel outputChannel;

    /**
     * The method prints the game score for all players in the list
     * @param gamePlayers a list of Player objects with their scores for each frame
     */
    @Override
    public void printScore(List<Player> gamePlayers) {
        outputChannel.print(HEADER_ROW);
        for (Player player : gamePlayers) {
            outputChannel.print(player.getName() + "\n");
            outputChannel.print(PINFALLS_COLUMN);
            printFramePinfalls(player.getFrames());
            outputChannel.print("\n");
            outputChannel.print(SCORES_COLUMN);
            printFrameScores(player.getFrames());
            outputChannel.print("\n");
        }
    }

    private void printFrameScores(List<Frame> frames) {
        int sum = 0;
        for (Frame frame : frames) {
            sum += frame.getScore();
            outputChannel.print(sum + "\t\t");
        }
    }

    private void printFramePinfalls(List<Frame> frames) {
        for (Frame frame : frames) {
            if (frame.isStrike()) {
                if (frame.getRolls().size() > 1) {
                    outputChannel.print(outputService.prepareMultiRollStrikeLine(frame));
                } else {
                    outputChannel.print(outputService.prepareSingleRollStrikeLine(frame));
                }
            } else if (frame.isSpare()) {
                outputChannel.print(outputService.prepareSpareLine(frame));
            } else {
                outputChannel.print(outputService.prepareStandardLine(frame));
            }
        }
    }
}
