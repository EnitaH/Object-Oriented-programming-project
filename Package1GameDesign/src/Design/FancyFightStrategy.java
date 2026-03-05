package Design;

import java.util.Scanner;

public class FancyFightStrategy implements IFightStrategy {

    @Override
    public boolean startFight(Player player, Scanner scanner, IWeapon weapon) {  // Return type is boolean
        System.out.println("You are fighting in a fancy room!");

        Zombie zombie = new Zombie(); // Create a zombie as the opponent.
        // Fight continues until either the player or the zombie's health reaches 0.
        while (player.getHealth() > 0 && zombie.getHealth() > 0) {
            System.out.println("\nWhat will you do?");
            System.out.println("1. attack the zombie's hands");
            System.out.println("2. attack the zombie's foot");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    int damage = weapon.attack();
                    zombie.takeDamage(damage);
                    System.out.println("You attacked with style! Zombie health: " + zombie.getHealth());
                }
                case 2 -> {
                    // Stun the zombie with flair.
                    System.out.println("Your mind momentarily stuns the zombie.");
                }
                default -> System.out.println("Invalid action! Try again.");
            }
        }
         // Determine the result of the fight.
        if (zombie.getHealth() <= 0) {
            System.out.println("You elegantly defeated the zombie!");
            return true;  // Player wins
        } else {
            System.out.println("The zombie ruined you and defeated you...");
            return false;  // Player loses
        }
    }
}
