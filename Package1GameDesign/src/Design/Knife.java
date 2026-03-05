package Design;

import java.util.Random; // Import for better random handling

public class Knife implements IWeapon {
    private final String name;

    // Constructor to initialize the name
    public Knife() {
        this.name = "Knife";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int attack() {
        Random random = new Random();
        return random.nextInt(3) + 3; // Random damage between 3 and 5 (inclusive)
    }
}
