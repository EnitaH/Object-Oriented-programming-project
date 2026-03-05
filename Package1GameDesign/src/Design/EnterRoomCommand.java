package Design;

import java.util.Scanner;

public class EnterRoomCommand implements ICommand {
    // The room to be entered.
    private RoomBehavior room;
    // The player attempting to enter the room.
    private Player player;
    // Scanner to read user input during the room interaction.
    private Scanner scanner;

    //Constructor
    public EnterRoomCommand(RoomBehavior room, Player player, Scanner scanner) {
        this.room = room;
        this.player = player;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        // Delegate to room's startRoom method
        return room.startRoom(player, scanner);  // Assuming startRoom now returns a boolean
    }
}
