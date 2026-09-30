package com.example.repov1.quarter2nd.minipeta3;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class ArcadeMainSystem {


    @Test
    public void testCompleteSystemFlow() {


        /*
         * Virtual keyboard / simulated user input
         */
        StringBuilder simulatedUserInput = new StringBuilder();


        System.out.println("--- GENERATING SIMULATED USER INPUTS ---");


        // 1. Create a player
        simulatedUserInput.append("1\n");
        simulatedUserInput.append("John Doe\n");
        simulatedUserInput.append("1234\n");


        // 2. Record a game score
        simulatedUserInput.append("2\n");
        simulatedUserInput.append("1234\n");
        simulatedUserInput.append("Space Shooter\n");
        simulatedUserInput.append("5000\n");


        // 3. View player's game records
        simulatedUserInput.append("3\n");
        simulatedUserInput.append("1234\n");


        // 4. View all players
        simulatedUserInput.append("4\n");


        // 5. Exit the program
        simulatedUserInput.append("5\n");


        // Convert simulated input into a Scanner
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        simulatedUserInput.toString().getBytes()
                );


        Scanner scanner = new Scanner(inputStream);


        // Run the Arcade System
        Main main = new Main();
        main.start(scanner);
    }
}
// Test this run if the all is working then commit and push(final step)
