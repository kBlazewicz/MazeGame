package pl.agh.edu.dp.labirynth.factory;


import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Wall;

public class NormalMazeFactory extends MazeFactory {
    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }

    public Wall createWall() {
        return new Wall();
    }

    public Room createRoom(int number, int x, int y) {
        return new Room(number, x, y);
    }
}
