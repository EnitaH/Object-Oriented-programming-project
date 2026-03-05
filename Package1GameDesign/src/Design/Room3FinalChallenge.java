package Design;

import java.util.Scanner;

public class Room3FinalChallenge implements RoomBehavior {

    private IFightStrategy fightStrategy;  // Store the fight strategy

    // Constructor accepting the IFightStrategy strategy for flexibility
    public Room3FinalChallenge(IFightStrategy fightStrategy) {
        if (fightStrategy == null) {
            throw new IllegalArgumentException("Fight strategy cannot be null");
        }
        this.fightStrategy = fightStrategy;
    }

    @Override
    public boolean startRoom(Player player, Scanner scanner) {
        System.out.println("Welcome to Room 3! You must solve the puzzle and then fight with the final enemy.");
        System.out.println("This room is different from the previous ones. Your enemy is the strongest, but there is a hint if you can solve the puzzles.");
        System.out.println("You have 3 puzzles to solve, and you have only one chance to answer each. If you answer at least 2 correctly, you'll get a hint.");
        System.out.println("If you fail to solve enough puzzles, you'll have to fight the zombies without a hint.");
        System.out.println("-----------------------------------------------");
        System.out.println("Press 1 to continue");

        int continueChoice = scanner.nextInt();
        if (continueChoice != 1) {
            System.out.println("You have to press 1 to continue the game.");
            return false; // Return false when the player does not choose to continue
        }

        // Puzzle solving section using PuzzleHelper
        int correctAnswers = 0;

        // Puzzle 1
        correctAnswers += PuzzleHelper.askPuzzle("5*6-(7+2)= ?", 21, scanner);

        // Puzzle 2
        correctAnswers += PuzzleHelper.askPuzzle("5-4(9*3)+6 = ?", 33, scanner);

        // Puzzle 3
        correctAnswers += PuzzleHelper.askPuzzle("1,4,9,... what is the next number?", 25, scanner);

        // Determine if the player gets the hint
        if (correctAnswers >= 2) {
            System.out.println("Congratulations! You can see the hint.");
            System.out.println("The hint is: This enemy loves blood.");
        } else {
            System.out.println("There is no hint to show you at this point.");
        }

        // Now, we start the final fight with the appropriate strategy
        return startZombieFight(player, scanner);
    }

    // Final Fight (Zombie Encounter)
    protected boolean startZombieFight(Player player, Scanner scanner) {
        System.out.println("You have to find the zombies first.");
        System.out.println("There are two doors that you can enter. Which one do you choose?");
        System.out.println("1. Bloody door");
        System.out.println("2. Clean door");

        int doorChoice = scanner.nextInt();
        if (doorChoice != 1) {
            System.out.println("You chose the wrong door! You lose!");
            return false; // Player loses and restarts
        }

        System.out.println("This is the correct door.");
        System.out.println("Pick your weapon from this list:");
        System.out.println("1. Sword");
        System.out.println("2. Knife");
        System.out.println("3. Ring");

        // Ensuring valid weapon selection
        IWeapon weapon = null;
        while (weapon == null) {
            int weaponChoice = scanner.nextInt();
            weapon = WeaponFactory.createWeapon(weaponChoice);
            if (weapon == null) {
                System.out.println("Invalid weapon selection. Try again.");
            }
        }

        System.out.println("Your current weapon is: " + weapon.getName());
        Zombie zombie = new Zombie();

        System.out.println("Player's health: " + player.getHealth());
        System.out.println("Zombie's health: " + zombie.getHealth());

        // The fight loop is delegated to the strategy
        return fightStrategy.startFight(player, scanner, weapon); // Delegate fight strategy here
    }
}
