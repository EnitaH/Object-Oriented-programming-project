package Design;

public class RoomFactory {

    public RoomBehavior createRoom(String roomName, String theme) {
        if (roomName == null || theme == null) {
            throw new IllegalArgumentException("Room name and theme cannot be null");
        }

        switch (roomName) {
            case "Room1":
                // Use different skill-based rooms based on the theme (e.g., SkillRoomHunted or SkillRoomFancy)
                if (theme.equalsIgnoreCase("Hunted")) {
                    return new SkillRoomHunted();  // Hunted version of Room 1
                } else {
                    return new SkillRoomFancy();  // Fancy version of Room 1
                }
            case "Room2":
                // For Room 2, we create PhysicalRoom and inject the right combat strategy based on the theme
                if (theme.equalsIgnoreCase("Hunted")) {
                    return new physicalRoom(new ZombieCombatStrategy());  // Inject ZombieCombatStrategy
                } else {
                    return new physicalRoom(new MagicalCreatureCombatStrategy());  // Inject MagicalCreatureCombatStrategy
                }
            case "Room3":
                // For Room 3, choose the correct final challenge room based on the theme
                if (theme.equalsIgnoreCase("Hunted")) {
                    return new Room3FinalChallenge(new ZombieFightStrategy()); // Inject ZombieFightStrategy for Hunted
                } else {
                    return new Room3FinalChallengeFancy(new FancyFightStrategy()); // Inject FancyFightStrategy for Fancy
                }
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomName);
        }
    }
}
