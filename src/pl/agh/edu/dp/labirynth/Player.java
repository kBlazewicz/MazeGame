package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.mazeParts.Direction;
import pl.agh.edu.dp.labirynth.mazeParts.MapSite;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.main.OutputManager;

public class Player {
    private final Room finalRoom;
    private final Bombardier bombardier;
    private boolean active = true;
    private Room room;

    public Player(Room startingRoom, Room finalRoom) {
        this.room = startingRoom;
        this.finalRoom = finalRoom;
        this.bombardier = new Bombardier(this); // outsourcing checking for bombarding
    }

    public void deactivate() {
        this.active = false;
    }

    public void goDirection(String move) {
        if (active) {
            Direction direction = interpretMove(move);
            if (direction == null) {
                return;
            }
            MapSite mapSite = this.room.getSide(direction);
            Room newRoom = mapSite.Enter(this.room);

            this.bombardier.checkForBombarding(this.room, newRoom);

            this.room = newRoom;
            if (this.room.equals(finalRoom)) {
                OutputManager.setConsoleMessage("Player deactivated");
                OutputManager.setConsoleMessage("YOU WON THE GAME!");
                deactivate();
            }
        }
    }

    private Direction interpretMove(String move) {
        switch (move) {
            case "up":
                return Direction.North;
            case "down":
                return Direction.South;
            case "left":
                return Direction.West;
            case "right":
                return Direction.East;
            default: {
                System.out.println("Bad move");
                return null;
            }
        }
    }
}
