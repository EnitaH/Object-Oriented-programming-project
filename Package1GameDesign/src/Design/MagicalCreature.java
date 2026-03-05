package Design;

public class MagicalCreature {
    private int health;

    public MagicalCreature() {
        this.health = 10;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int attack() {
        return (int) (Math.random() * 3) + 1;  // MagicalCreature's attack damage is between 1 and 3
    }
}
