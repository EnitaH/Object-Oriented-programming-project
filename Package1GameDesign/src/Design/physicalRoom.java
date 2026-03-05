package Design;

import java.util.Scanner;

public class physicalRoom implements RoomBehavior {
    private ICombatStrategy combatStrategy; // Combat strategy for this room

    // Constructor accepts the combat strategy
    public physicalRoom(ICombatStrategy combatStrategy) {
        this.combatStrategy = combatStrategy;
    }

    @Override
    public boolean startRoom(Player player, Scanner scanner) {
        // Delegate the combat logic to the strategy
        combatStrategy.executeCombat(player, scanner);
        return true; // You can return false based on combat results if necessary
    }
}
