package Design;

public class Zombie {

    private int health;

    public Zombie() {
        this.health = 10;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int attack() {
        return (int) (Math.random() * 3) + 1;  // Zombie's attack damage is between 1 and 3
    }
}
