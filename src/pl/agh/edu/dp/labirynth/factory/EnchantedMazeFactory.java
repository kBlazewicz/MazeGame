package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.mazeParts.enchanted.EnchantedDoor;
import pl.agh.edu.dp.labirynth.mazeParts.enchanted.EnchantedRoom;
import pl.agh.edu.dp.labirynth.mazeParts.enchanted.EnchantedWall;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Wall;

public class EnchantedMazeFactory extends MazeFactory {

    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }

    public Wall createWall() {
        return new EnchantedWall();
    }

    public Room createRoom(int number, int x, int y) {
        return new EnchantedRoom(number, x, y);
    }
}
