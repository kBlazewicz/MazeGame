package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.mazeParts.Direction;
import pl.agh.edu.dp.labirynth.mazeParts.MapSite;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

import static java.lang.System.exit;

public class Player {
    private final Room finalRoom;
    private Room room;
    private final Bombardier bombardier;

    public Player(Room startingRoom, Room finalRoom) {
        this.room = startingRoom;
        this.finalRoom = finalRoom;
        this.bombardier = new Bombardier(); // outsourcing checking for bombarding
    }

    public void goDirection(String move) {
        Direction direction = interpretMove(move);
        if (direction == null) {
            return;
        }
        MapSite mapSite = this.room.getSide(direction);
        Room newRoom = mapSite.Enter(this.room);

        this.bombardier.checkForBombarding(this.room,newRoom);

        this.room = newRoom;
        if (this.room.equals(finalRoom)) {
            System.out.println("YOU WON THE GAME!");
            exit(0);
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
