package pl.agh.edu.dp.labirynth.mazeParts.normal;

import pl.agh.edu.dp.labirynth.mazeParts.Direction;
import pl.agh.edu.dp.labirynth.mazeParts.MapSite;

import java.util.EnumMap;
import java.util.Map;

public class Room {
    private final int x;
    private final int y;
    private final int roomNumber;
    private final Map<Direction, MapSite> sides;

    public Room(int number, int x, int y) {
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
        this.x = x;
        this.y = y;
    }

    public MapSite getSide(Direction direction) {
        return this.sides.get(direction);
    }

    public void setSide(Direction direction, MapSite ms) {
        this.sides.put(direction, ms);
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Normal Room";
    }

    public boolean isBeingBombarded() {
        return false;
    }
}
