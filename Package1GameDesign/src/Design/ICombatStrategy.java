package Design;

import java.util.Scanner;
//Interface that defines the contract for combat strategies.
//Any class that implements this interface must provide an implementation for the executeCombat method.
 
public interface ICombatStrategy {
    //This method will define how the combat should be carried out in different scenarios (e.g., fighting a zombie, a magical creature).
    //player the player engaged in the combat.
    //scanner the scanner used to capture player input during combat.
    //boolean indicating whether the player wins (true) or loses (false) the combat.
    boolean executeCombat(Player player, Scanner scanner);
}
