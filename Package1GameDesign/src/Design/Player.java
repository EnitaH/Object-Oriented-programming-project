package Design;

public class Player {
    private int health;
    private IWeapon weapon;
    private static final int MAX_HEALTH = 10; // Assuming 10 is the max health

    public Player() {
        this.health = MAX_HEALTH;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public void resetHealth() {
        this.health = MAX_HEALTH; // Reset health to the initial maximum
    }
    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public IWeapon getWeapon() {
        return weapon;
    }
}

