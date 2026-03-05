package Design;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Welcome message
            System.out.println("Welcome to the Subway Hunted Game!");
            System.out.print("Please enter your name: ");
            String playerName = scanner.nextLine().trim();

            if (playerName.isEmpty()) {
                System.out.println("You didn't enter a name. Defaulting to 'Player'.");
                playerName = "Player";
            }
            System.out.println("Hi " + playerName + ", let's begin your adventure!");

            Player player = new Player();
            String[] themeHolder = new String[1];

            // Choose theme using Command
            ICommand chooseThemeCommand = new ChooseThemeCommand(scanner, themeHolder);
            chooseThemeCommand.execute();
            String theme = themeHolder[0];

            RoomFactory roomFactory = new RoomFactory();

            // Enter Room 1 using Command
            RoomBehavior room1 = roomFactory.createRoom("Room1", theme);
            ICommand enterRoom1Command = new EnterRoomCommand(room1, player, scanner);
            enterRoom1Command.execute();

            System.out.println("\nBack to the main hall...");
            System.out.println("These are our rooms in the main hall:");
            System.out.println("Room 1: Skill Room solving puzzles");
            System.out.println("Room 2: Physical Room, fighting with enemy");
            System.out.println("Room 3: Ultimate, comprising both enemy and puzzle challenges");

            // Ask to enter Room 2
            int choice = getValidChoice(scanner, "Are you ready for the second room? 1. Yes 2. No: ");
            
            switch (choice) {
                case 1:
                    // Create Room 2 based on the theme
                    RoomBehavior room2 = roomFactory.createRoom("Room2", theme);
                    ICommand enterRoom2Command = new EnterRoomCommand(room2, player, scanner);
                    boolean room2Result = enterRoom2Command.execute();  // Capture the result of combat

                    if (room2Result) {
                        System.out.println("You survived Room 2!");
                    } else {
                        System.out.println("You failed to survive Room 2.");
                        return;  // Exit the game if the player loses
                    }
                    break;
                case 2:
                    System.out.println("Thank you for playing!");
                    return;  // Exit the game
                default:
                    System.out.println("Invalid input. Exiting.");
                    return;  // Exit the game
            }

            // Recharge player health for next rooms
            player.setHealth(10);

            // Ask if ready for Room 3
            choice = getValidChoice(scanner, "\nAre you ready for the third room? 1. Yes 2. No: ");

            switch (choice) {
                case 1:
                    System.out.print("Which theme would you like to choose for the third room: Hunted or Fancy? ");
                    String room3Theme = scanner.nextLine().trim();
                    RoomBehavior room3;

                    if (room3Theme.equalsIgnoreCase("Fancy")) {
                        // Create a FancyFightStrategy for Room 3 Fancy
                        FancyFightStrategy fancyFightStrategy = new FancyFightStrategy();
                        // Pass the strategy to the Room3FinalChallengeFancy constructor
                        room3 = new Room3FinalChallengeFancy(fancyFightStrategy);  // Pass the strategy to the constructor
                    } else {
                        // Create a ZombieFightStrategy for Room 3
                        ZombieFightStrategy zombieFightStrategy = new ZombieFightStrategy();
                        // Pass the strategy to the Room3FinalChallenge constructor
                        room3 = new Room3FinalChallenge(zombieFightStrategy);  // Pass the strategy to the constructor
                    }
                    ICommand enterRoom3Command = new EnterRoomCommand(room3, player, scanner);
                    enterRoom3Command.execute();
                    break;
                case 2:
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid input. Exiting.");
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Helper method to handle valid numeric input (1 or 2)
    private static int getValidChoice(Scanner scanner, String prompt) {
        int choice = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 for Yes or 2 for No.");
                }
            } else {
                System.out.println("Invalid input. Please enter 1 for Yes or 2 for No.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }
}
