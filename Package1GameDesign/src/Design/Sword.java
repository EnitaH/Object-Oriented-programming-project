package Design;

//Implements the IWeapon interface.
public class Sword implements IWeapon {
    private final String name;
    private final int damage;

    //Constructor to initialize the Sword with a name and damage value.
    public Sword() {
        this.name = "Sword";
        this.damage = 5; // Damage dealt by the sword
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int attack() {
        System.out.println("Swinging the Sword!");
        return damage; // Return the damage value
}
}
