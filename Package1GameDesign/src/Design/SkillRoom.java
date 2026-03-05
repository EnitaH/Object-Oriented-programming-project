package Design;

import java.util.Scanner;

public class SkillRoom implements RoomBehavior {
    protected String name;

    //Constructor
    public SkillRoom(String name) {
        this.name = name;
    }

    @Override
    public boolean startRoom(Player player, Scanner scanner) {
        System.out.println("Now you are in " + name + ".");
        System.out.println("There is a mathematical problem on the wall, and you have to solve it to get out of this room.");
        System.out.println("You have 2 chances to solve the problem.");
        
        // Call the solveChallenge method and return the result
        return solveChallenge(player, scanner); // Return true or false based on solving the challenge
    }

    public boolean solveChallenge(Player player, Scanner scanner) { // Modified to return boolean
        int chances = 2; // Number of attempts allowed.
        boolean solved = false;

        while (chances > 0 && !solved) {
            System.out.println("Solve this: 5 - (8 * 7) + (5 * 4)");
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            if (answer == 71) { // Correct answer condition.
                System.out.println("You have done the puzzle. You have completed the first room!");
                solved = true;
            } else { // Incorrect answer condition.
                chances--;
                if (chances > 0) {
                    System.out.println("You still have one more chance.");
                } else {
                    System.out.println("You're failed and you have to solve this room to pop into the second room.");
                    player.takeDamage(10); // Example of affecting the player
                    System.out.println("Game Over! You failed the puzzle after 2 attempts.");
                    System.exit(0); // Exit the game immediately
                }
            }
        }

        // Return whether the puzzle was solved or not
        return solved; // Return true if solved, false if not
    }
}
