package Design;

import java.util.Scanner;

public class Room3FinalChallengeFancy implements RoomBehavior {
    private IFightStrategy fightStrategy;

    // Constructor accepts FancyFightStrategy
    public Room3FinalChallengeFancy(FancyFightStrategy fightStrategy) {
        this.fightStrategy = fightStrategy;
    }

    @Override
    public boolean startRoom(Player player, Scanner scanner) {
        System.out.println("Welcome to the Fancy Room 3!");
        System.out.println("By solving at least 2 out of 3 puzzles you will get a Golden Weapon to fight with Zombie!");

        // Wait for player to continue
        System.out.println("Press 1 to continue.");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Exiting the room.");
            scanner.next(); // Clear invalid input
            return false;
        }
        int continueChoice = scanner.nextInt();
        if (continueChoice != 1) {
            System.out.println("You must press 1 to proceed.");
            return false; // Exit if the player doesn't continue
        }

        // Puzzle solving section
        int correctAnswers = 0;
        correctAnswers += PuzzleHelper.askPuzzle("5*6-(7+2)= ?", 21, scanner);
        correctAnswers += PuzzleHelper.askPuzzle("5-4(9*3)+6 = ?", 33, scanner);
        correctAnswers += PuzzleHelper.askPuzzle("1,4,9,... what is the next number?", 25, scanner);

        // Fancy reward based on puzzle results
        if (correctAnswers >= 2) {
            System.out.println("Fantastic! You get a golden weapon for the fight.");
            startFancyFight(player, scanner, true); // Pass true for golden weapon
        } else {
            System.out.println("You didn't solve enough puzzles. You get a standard weapon.");
            startFancyFight(player, scanner, false); // Pass false for standard weapon
        }

        return true; // Room successfully completed
    }

    private void startFancyFight(Player player, Scanner scanner, boolean hasGoldenWeapon) {
        System.out.println("Prepare for a fancy showdown!");

        IWeapon weapon;

        // Weapon selection
        if (hasGoldenWeapon) {
            // Create a Golden Sword directly
            weapon = new GoldenSword();
        } else {
            // Standard weapon selection
            while (true) {
                System.out.println("Choose your standard weapon: ");
                System.out.println("1. Sword ");
                System.out.println("2. Knife ");
                System.out.println("3. Ring  ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                int weaponChoice = scanner.nextInt();
                weapon = WeaponFactory.createWeapon(weaponChoice);

                if (weapon != null) {
                    break; // Exit loop if valid weapon is created
                } else {
                    System.out.println("Invalid choice! Please try again.");
                }
            }
        }

        // Create a zombie for the fight
        Zombie zombie = new Zombie();

        // Display initial states
        System.out.println("Your weapon is: " + weapon.getName());
        System.out.println("Player's health: " + player.getHealth());
        System.out.println("Zombie's health: " + zombie.getHealth());

        // Combat loop
        while (player.getHealth() > 0 && zombie.getHealth() > 0) {
            System.out.println("\nWhat will you do?");
            System.out.println("1. Hit the zombie's hands.");
            System.out.println("2. Hit the zombie's feet.");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter 1 or 2.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    int damage = weapon.attack();
                    zombie.takeDamage(damage);
                    System.out.println("You attacked! Zombie health: " + zombie.getHealth());
                }
                case 2 -> {
                    System.out.println("Your mind momentarily stuns the zombie.");
                }
                default -> {
                    System.out.println("Invalid action! Please try again.");
                }
            }
        }

        // Outcome of the fight
        if (zombie.getHealth() <= 0) {
            System.out.println("You power defeated the zombie!");
        } else {
            System.out.println("The zombie ruined you and defeated you...");
        }
    }
}
