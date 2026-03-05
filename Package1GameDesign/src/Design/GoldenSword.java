package Package1GameDesign;

public class GoldenSword implements IWeapon {
    private final String name;
    private final int damage; //// Damage dealt by the weapon.

    //Constructor
    public GoldenSword() {
        this.name = "Golden Sword";
        this.damage = 6; // Set high damage for the golden weapon
    }

    //Returns the name of the weapon.

    @Override
    public String getName() {
        return name;
    }
    //Returns the damage dealt by the golden sword.
    @Override
    public int attack() {
        System.out.println("Swinging the Golden Sword with a powerful strike!");
        return damage;
    }
}
