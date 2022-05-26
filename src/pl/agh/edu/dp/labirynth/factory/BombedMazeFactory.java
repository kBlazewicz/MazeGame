package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.mazeParts.bombed.BombedDoor;
import pl.agh.edu.dp.labirynth.mazeParts.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.mazeParts.bombed.BombedWall;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Wall;

public class BombedMazeFactory extends MazeFactory {

    public Door createDoor(Room room1, Room room2) {
        return new BombedDoor(room1, room2);
    }

    public Wall createWall() {
        return new BombedWall();
    }

    public Room createRoom(int number, int x, int y) {
        return new BombedRoom(number, x, y);
    }
}
