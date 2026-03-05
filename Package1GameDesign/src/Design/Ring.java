package Design;

import java.util.Random; // Import for better random handling

public class Ring implements IWeapon {
    private final String name;

    // Constructor to initialize the name
    public Ring() {
        this.name = "Ring";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int attack() {
        Random random = new Random();
        return random.nextInt(3) + 1; // Random damage between 1 and 3 (inclusive)
    }
}
