package Design;

import java.util.Scanner;
//This strategy is used in the Fancy Room, where the player faces a magical creature.
public class MagicalCreatureCombatStrategy implements ICombatStrategy {
    @Override
    public boolean executeCombat(Player player, Scanner scanner) {
        // Display introductory text for the combat encounter
        System.out.println("You are now in Room 2 – The Fancy Room.");
        System.out.println("Your goal: kill this magical creature encounter.");

        System.out.println("Choose your weapon to survive this encounter:");
        System.out.println("1. Sword");
        System.out.println("2. Knife");
        System.out.println("3. Ring");

        // Read player's weapon choice and create the corresponding weapon
        int choice = scanner.nextInt();
        IWeapon weapon = WeaponFactory.createWeapon(choice);
        System.out.println("Your weapon is: " + weapon.getName());

        // Create the magical creature to fight
        MagicalCreature magicalCreature = new MagicalCreature();

          // Display the initial health stats of the player and the creature
        System.out.println("\nThe magical creature appears with a sparkle!");
        System.out.println("Your health: " + player.getHealth());
        System.out.println("Magical Creature's health: " + magicalCreature.getHealth());

        // Combat loop until either the player or the magical creature dies
        while (player.getHealth() > 0 && magicalCreature.getHealth() > 0) {
            System.out.println("\nWhat will you do? Choose your action.");
            System.out.println("1. Attack the magical creature.");
            System.out.println("2. Try to charm the creature.");
            System.out.println("3. Flee to the main hall.");

            // Validate the player's input and ensure it's one of the valid actions
            int action = -1;
            while (action < 1 || action > 3) {
                if (scanner.hasNextInt()) {
                    action = scanner.nextInt();
                } else {
                    scanner.next(); // Consume invalid input
                    System.out.println("Invalid input. Please choose a valid action.");
                }
            }

             // Execute the corresponding action based on the player's choice
            switch (action) {
                case 1 -> {
                    int damage = weapon.attack();
                    magicalCreature.takeDamage(damage);
                    System.out.println("You attacked the magical creature, dealing " + damage + " damage.");
                    player.takeDamage(magicalCreature.attack());
                }
                case 2 -> {
                    System.out.println("You try to charm the creature...");
                    player.takeDamage(magicalCreature.attack());
                    magicalCreature.takeDamage(weapon.attack());
                }
                case 3 -> {
                    System.out.println("You decided to flee back to the main hall.");
                    return false;  // Player flees, combat is unsuccessful
                }
                default -> System.out.println("Invalid action. Try again.");
            }

            System.out.println("\nYour health: " + player.getHealth());
            System.out.println("Magical Creature's health: " + magicalCreature.getHealth());
        }
        //  // Determine the outcome of the combat
        if (magicalCreature.getHealth() <= 0) {
            System.out.println("You defeated the magical creature!");
            return true;  // Player wins
        } else {
            System.out.println("You were overwhelmed by the magical creature. You lost!");
            return false;  // Player loses
        }
    }
}
