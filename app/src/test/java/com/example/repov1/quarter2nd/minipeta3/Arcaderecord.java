package com.example.repov1.quarter2nd.minipeta3;

import java.time.LocalDateTime;

public class Arcaderecord {
    private String gameName;
    private int score;
    private LocalDateTime gameTime;

    public Arcaderecord(String gameName, int score, LocalDateTime gameTime) {
        this.gameName = gameName;
        this.score = score;
        this.gameTime = gameTime;
    }

    @Override
    public String toString() {
        return "Game: " + gameName
                + ", Score: " + score
                + ", Time: " + gameTime;
    }
}
