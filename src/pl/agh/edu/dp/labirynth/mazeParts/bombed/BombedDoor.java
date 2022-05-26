package pl.agh.edu.dp.labirynth.mazeParts.bombed;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

public class BombedDoor extends Door {
    public BombedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public String toString() {
        return "Bombed Door";
    }
}
