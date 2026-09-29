package com.example.repov1.quarter2nd.minipeta3;

import java.util.ArrayList;
//Step 2 Player Profile Class
public class player {
    private final String playerName;
    private final String playerID;
    private final ArrayList<Arcaderecord> gameRecords;

    public player(String name, String ID) {
        this.playerName = name;
        this.playerID = ID;
        this.gameRecords = new ArrayList<>();
    }

    public String getName() {
        return playerName;
    }

    public String getID() {
        return playerID;
    }

    public void addGameRecord(Arcaderecord record) {
        gameRecords.add(record);
    }

    public void printGameRecords() {
        if (gameRecords.isEmpty()) {
            System.out.println("No game records found.");
            return;
        }

        for (Arcaderecord record : gameRecords) {
            System.out.println(record);
        }
    }
}
