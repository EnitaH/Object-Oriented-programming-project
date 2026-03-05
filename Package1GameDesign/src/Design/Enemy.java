package Design;


//It defines shared properties and behaviors for enemies
public abstract class Enemy {
    private int health;

    //Gets the current health of the enemy.
    public Enemy(int health) {
        this.health = health;
    }
    //Gets the current health of the enemy and return the current health value.
    public int getHealth() {
        return health;
    }
    //Reduces the enemy's health
    public void takeDamage(int damage) {
        health -= damage; // Subtract the damage from the enemy's health
    }

    public abstract int attack();
}
