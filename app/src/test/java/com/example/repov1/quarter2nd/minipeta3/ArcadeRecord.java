package com.example.repov1.quarter2nd.minipeta3;

import java.time.LocalDateTime;

public class ArcadeRecord {
    private final String gameName;
    private final int score;
    private final LocalDateTime gameTime;

    public ArcadeRecord(String gameName, int score, LocalDateTime gameTime) {
        this.gameName = gameName;
        this.score = score;
        this.gameTime = gameTime;
    }

    public String getGameName() {
        return gameName;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getGameTime() {
        return gameTime;
    }

    @Override
    public String toString() {
        return "Game: " + gameName + " | Score: " + score + " | Date: " + gameTime;
    }
}
