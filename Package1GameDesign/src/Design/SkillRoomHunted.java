package Design;

import java.util.Scanner;

public class SkillRoomHunted extends SkillRoom {
    public SkillRoomHunted() {
        super("Skill Room (Hunted)");
    }

    @Override
    public boolean  startRoom(Player player, Scanner scanner) {
        System.out.println("Welcome to the Hunted Skill Room.");
          return super.solveChallenge(player, scanner); // Use the existing logic from SkillRoom
    }
}
