package Design;
import java.util.Scanner;
public interface IFightStrategy {
    // Return a boolean to indicate win/lose
    boolean startFight(Player player, Scanner scanner, IWeapon weapon);
}
