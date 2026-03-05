package Design;

import java.util.Scanner;
//The ChooseThemeCommand class implements the ICommand interface.
//This command allows the player to choose a theme for their adventure.
public class ChooseThemeCommand implements ICommand {
     // Scanner instance for reading input from the player.
    private Scanner scanner;
    // A single-element array allows the theme to be shared between methods or objects.
    private String[] themeHolder;
    //Constructor
    public ChooseThemeCommand(Scanner scanner, String[] themeHolder) {
        this.scanner = scanner;
        this.themeHolder = themeHolder;
    }

    //Displays the options to the player and captures their choice.
    @Override
    public boolean execute() {
        System.out.println("Choose your theme for the adventure:");
        System.out.println("1. Hunted");
        System.out.println("2. Fancy");
        //Read the player's choice
        int choice = scanner.nextInt();
        // Assign the chosen theme based on the input
        if (choice == 1) {
            themeHolder[0] = "Hunted";
        } else if (choice == 2) {
            themeHolder[0] = "Fancy";
        } else {
            System.out.println("Invalid choice. Defaulting to 'Hunted'.");
            themeHolder[0] = "Hunted";
        }
        // Return true to indicate the command execution was successful
        return true;  
    }
}
