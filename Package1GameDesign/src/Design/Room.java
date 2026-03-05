package Design;

//This is an abstract class that serves as a base for different room types.
public abstract class Room {
    protected String name;
    
    // Constructor to initialize a room with a name.
    public Room(String name) {
        this.name = name; // Initialize the room with a specific name
    }

    public abstract void startRoom(Player player);  // Abstract method for starting the room
}


