package com.backend.jobsity_challenge.controller;

import com.backend.jobsity_challenge.model.Player;
import com.backend.jobsity_challenge.model.Roll;
import com.backend.jobsity_challenge.service.FrameService;
import com.backend.jobsity_challenge.service.InputService;
import com.backend.jobsity_challenge.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ScoringControllerImpl implements ScoringController {

    @Autowired
    private FrameService frameService;

    @Autowired
    private InputService inputService;

    @Autowired
    private ParseService parseService;

    /**
     * The method calculates the score along 10 frames for every player supplied
     * @return a list of Player objects with their score in each frame
     */
    @Override
    public List<Player> calculateScores() {
        Map<String, List<Roll>> rolls = parseService.parse(inputService.getInput());

        List<Player> players = rolls.keySet()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        
        players.forEach(player -> player.addFrames(
                frameService.createGameFrames(rolls.get(player.getName()))));

        return players;
    }
}
