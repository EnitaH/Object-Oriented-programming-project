package Design;

import java.util.Scanner;

public class ZombieFightStrategy implements IFightStrategy {

    @Override
    public boolean startFight(Player player, Scanner scanner, IWeapon weapon) {
        System.out.println("You have to fight a Zombie!");

        Zombie zombie = new Zombie();
        while (player.getHealth() > 0 && zombie.getHealth() > 0) {
            System.out.println("\nWhat will you do?");
            System.out.println("1. Attack the zombie from the right side.");
            System.out.println("2. Attack the zombie from the left side.");

            int attackChoice = scanner.nextInt();
            int playerDamage = weapon.attack();
            int zombieDamage = zombie.attack();

            switch (attackChoice) {
                case 1 -> {
                    zombie.takeDamage(playerDamage);
                    player.takeDamage(zombieDamage);
                    System.out.println("Zombie's health: " + zombie.getHealth());
                    System.out.println("Player's health: " + player.getHealth());
                }
                case 2 -> {
                    zombie.takeDamage(playerDamage);
                    player.takeDamage(zombieDamage);
                    System.out.println("Zombie's health: " + zombie.getHealth());
                    System.out.println("Player's health: " + player.getHealth());
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        if (zombie.getHealth() <= 0) {
            System.out.println("You defeated the zombie!");
            return true;  // Victory
        } else {
            System.out.println("The zombie defeated you.");
            return false;  // Defeat
        }
    }
}
