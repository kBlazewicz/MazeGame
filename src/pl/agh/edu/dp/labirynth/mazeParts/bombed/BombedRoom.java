package pl.agh.edu.dp.labirynth.mazeParts.bombed;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number, int x, int y) {
        super(number, x, y);
    }

    @Override
    public String toString() {
        return "Bombed Room";
    }

    @Override
    public boolean isBeingBombarded() {
        return true;
    }
}
