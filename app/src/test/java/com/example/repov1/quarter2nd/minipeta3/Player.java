package com.example.repov1.quarter2nd.minipeta3;

import java.util.ArrayList;
import java.util.List;

// Step 2 Player Profile Class 
public class Player {
    private final String playerName;
    private final String playerID;
    private final List<ArcadeRecord> gameRecords;

    public Player(String name, String id) {
        this.playerName = name;
        this.playerID = id;
        this.gameRecords = new ArrayList<>();
    }

    public String getName() {
        return playerName;
    }

    public String getID() {
        return playerID;
    }

    public List<ArcadeRecord> getGameRecords() {
        return gameRecords;
    }

    public void addGameRecord(ArcadeRecord record) {
        gameRecords.add(record);
    }

    public void printGameRecords() {
        if (gameRecords.isEmpty()) {
            System.out.println("No records found for this player.");
            return;
        }

        for (ArcadeRecord record : gameRecords) {
            System.out.println(" - " + record);
        }
    }
}
