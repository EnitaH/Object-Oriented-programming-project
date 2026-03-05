package Design;

public class WeaponFactory {

    // Method to create a weapon, optionally as a golden weapon
    public static IWeapon createWeapon(int choice, boolean isGolden) {
        if (isGolden) {
            return new GoldenSword();
        }

        switch (choice) {
            case 1:
                return new Sword();
            case 2:
                return new Knife();
            case 3:
                return new Ring();
            default:
                System.out.println("Invalid choice! Defaulting to Sword.");
                return new Sword(); // Default weapon is Sword
        }
    }

    // Overloaded method to create a non-golden weapon based on choice
    public static IWeapon createWeapon(int choice) {
        return createWeapon(choice, false); // Default to non-golden
    }
}
