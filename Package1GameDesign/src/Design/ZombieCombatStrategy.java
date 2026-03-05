package Design;

import java.util.Scanner;

public class ZombieCombatStrategy implements ICombatStrategy {
    /**
     * Executes the zombie combat scenario.
     * the player engaged in combat.
     * the scanner for user input.
     * returns true if the player defeats the zombie, false otherwise.
     */
    public boolean executeCombat(Player player, Scanner scanner) {
        System.out.println("You are now in Room 2 – The Hunted Room.");
        System.out.println("Your goal: Survive this deadly zombie encounter.");
         // Prompt the player to choose a weapon
        System.out.println("Choose your weapon to survive this encounter:");
        System.out.println("1. Sword");
        System.out.println("2. Knife");
        System.out.println("3. Ring");

        int choice = scanner.nextInt();
        IWeapon weapon = WeaponFactory.createWeapon(choice);
        System.out.println("Your weapon is: " + weapon.getName());

        Zombie zombie = new Zombie(); // Create a zombie for the encounter

        System.out.println("\nThe zombie emerges from the shadows!");
        System.out.println("Your health: " + player.getHealth());
        System.out.println("Zombie's health: " + zombie.getHealth());

        // Combat loop until either player or zombie is defeated
        while (player.getHealth() > 0 && zombie.getHealth() > 0) {
            System.out.println("\nWhat will you do? Choose your action.");
            System.out.println("1. Attack the zombie.");
            System.out.println("2. Try to reason with the zombie.");
            System.out.println("3. Flee to the main hall.");

            int action = -1;
            while (action < 1 || action > 3) {
                if (scanner.hasNextInt()) {
                    action = scanner.nextInt();
                } else {
                    scanner.next(); // Consume invalid input
                    System.out.println("Invalid input. Please choose a valid action.");
                }
            }

            switch (action) {
                case 1 -> { // Attack the zombie
                    int damage = weapon.attack();
                    zombie.takeDamage(damage);
                    System.out.println("You attacked the zombie, dealing " + damage + " damage.");
                    player.takeDamage(zombie.attack());
                }
                case 2 -> { // Attempt to reason with the zombie
                    System.out.println("You try to talk to the zombie...");
                    player.takeDamage(zombie.attack());
                    zombie.takeDamage(weapon.attack()); // Player attacks in response
                }
                case 3 -> { // Flee the encounter
                    System.out.println("You decided to flee back to the main hall.");
                    return false; // Player flees
                }
                default -> System.out.println("Invalid action. Try again.");
            }

            System.out.println("\nYour health: " + player.getHealth());
            System.out.println("Zombie's health: " + zombie.getHealth());
        }

        if (zombie.getHealth() <= 0) {
            System.out.println("You defeated the zombie!");
            return true; // Player wins
        } else {
            System.out.println("You were overwhelmed by the zombie. You lost!");
            return false; // Player loses
        }
    }
}
