package com.backend.jobsity_challenge.controller;

import com.backend.jobsity_challenge.model.Player;

import java.util.List;

public interface OutputController {
    void printScore(List<Player> gamePlayers);
}
