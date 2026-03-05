package Design;

import java.util.Scanner;

public class SkillRoomFancy extends SkillRoom {
    public SkillRoomFancy() {
        super("Skill Room (Fancy)");
    }

    @Override
    public boolean startRoom(Player player, Scanner scanner) {
        System.out.println("Welcome to the Fancy Skill Room.");

        // Call the solveChallenge method and handle the result
        boolean solved = super.solveChallenge(player, scanner);
        
        if (solved) {
            System.out.println("You solved the challenge! You may now move forward.");
        } else {
            System.out.println("You failed to solve the challenge. You need to try again.");
        }

        return solved; // Return the result of solving the challenge
    }
}
