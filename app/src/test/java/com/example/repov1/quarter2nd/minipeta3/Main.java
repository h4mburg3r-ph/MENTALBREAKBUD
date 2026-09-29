package com.example.repov1.quarter2nd.minipeta3;import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // --- INNER CLASS 1: PlayerProfile ---
    public static class PlayerProfile {
        private String name;
        private String id;
        private List<ArcadeSystemRecord> gameRecords;

        public PlayerProfile(String name, String id) {
            this.name = name;
            this.id = id;
            this.gameRecords = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getID() {
            return id;
        }

        public void addGameRecord(ArcadeSystemRecord record) {
            gameRecords.add(record);
        }

        public void printGameRecords() {
            if (gameRecords.isEmpty()) {
                System.out.println("No records found for this player.");
                return;
            }
            for (ArcadeSystemRecord record : gameRecords) {
                System.out.println(" - " + record);
            }
        }
    }

    // --- INNER CLASS 2: ArcadeSystemRecord ---
    public static class ArcadeSystemRecord {
        private String gameName;
        private int score;
        private LocalDateTime timestamp;

        public ArcadeSystemRecord(String gameName, int score, LocalDateTime timestamp) {
            this.gameName = gameName;
            this.score = score;
            this.timestamp = timestamp;
        }

        public String getGameName() {
            return gameName;
        }

        public int getScore() {
            return score;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "Game: " + gameName + " | Score: " + score + " | Date: " + timestamp;
        }
    }

    // --- MAIN METHOD & LOGIC ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main system = new Main();
        system.start(scanner);
    }

    public void start(Scanner scanner) {
        ArrayList<PlayerProfile> players = new ArrayList<>();

        while (true) {
            System.out.println("\n===== ARCADE SYSTEM =====");
            System.out.println("1: Create Player");
            System.out.println("2: Record Game Score");
            System.out.println("3: View Player Game Records");
            System.out.println("4: View All Players");
            System.out.println("5: Exit");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            System.out.println("Chosen Decision: " + choice);

            if (!decisionCompress(choice, scanner, players)) {
                break;
            }
        }
    }

    public static void createPlayer(Scanner scanner, ArrayList<PlayerProfile> players) {
        System.out.println("\n===== CREATE PLAYER =====");

        System.out.print("Player Name: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Player creation cancelled.");
            return;
        }

        System.out.print("Player ID: ");
        String id = scanner.nextLine();

        for (PlayerProfile player : players) {
            if (player.getID().equals(id)) {
                System.out.println("PLAYER ID ALREADY EXISTS.");
                return;
            }
        }

        players.add(new PlayerProfile(name, id));
        System.out.println("Player successfully created!");
    }

    public static void recordGameScore(Scanner scanner, ArrayList<PlayerProfile> players) {
        System.out.println("\n===== RECORD GAME SCORE =====");

        System.out.print("Player ID: ");
        String id = scanner.nextLine();

        PlayerProfile selectedPlayer = null;

        for (PlayerProfile player : players) {
            if (player.getID().equals(id)) {
                selectedPlayer = player;
                break;
            }
        }

        if (selectedPlayer == null) {
            System.out.println("PLAYER NOT FOUND.");
            return;
        }

        System.out.print("Game Name: ");
        String gameName = scanner.nextLine();

        System.out.print("Score: ");
        int score;

        try {
            score = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid score.");
            return;
        }

        if (score < 0) {
            System.out.println("Score cannot be negative.");
            return;
        }

        LocalDateTime time = LocalDateTime.now();
        ArcadeSystemRecord record = new ArcadeSystemRecord(gameName, score, time);

        selectedPlayer.addGameRecord(record);
        System.out.println("Game score successfully recorded!");
    }

    public static void printPlayerRecords(Scanner scanner, ArrayList<PlayerProfile> players) {
        System.out.println("\n===== PLAYER RECORDS =====");

        System.out.print("Player ID: ");
        String id = scanner.nextLine();

        for (PlayerProfile player : players) {
            if (player.getID().equals(id)) {
                System.out.println("Player: " + player.getName());
                player.printGameRecords();
                return;
            }
        }

        System.out.println("PLAYER NOT FOUND.");
    }

    public static void printAllPlayers(ArrayList<PlayerProfile> players) {
        System.out.println("\n===== ALL PLAYERS =====");

        if (players.isEmpty()) {
            System.out.println("No players registered.");
            return;
        }

        for (PlayerProfile player : players) {
            System.out.println("Name: " + player.getName() + ", ID: " + player.getID());
        }
    }

    public static boolean decisionCompress(int choice, Scanner scanner, ArrayList<PlayerProfile> players) {
        if (choice == 1) {
            createPlayer(scanner, players);
        } else if (choice == 2) {
            recordGameScore(scanner, players);
        } else if (choice == 3) {
            printPlayerRecords(scanner, players);
        } else if (choice == 4) {
            printAllPlayers(players);
        } else if (choice == 5) {
            System.out.println("CLOSING ARCADE SYSTEM.");
            return false;
        } else {
            System.out.println("INVALID DECISION.");
        }

        return true;
    }
}
