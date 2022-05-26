package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Wall;

public abstract class MazeFactory {
    private static MazeFactory enchantedMazeFactoryInstance = null;
    private static MazeFactory bombedMazeFactoryInstance = null;
    private static MazeFactory normalMazeFactoryInstance = null;

    public static MazeFactory getEnchantedMazeFactoryInstance() {
        if (enchantedMazeFactoryInstance == null) {
            enchantedMazeFactoryInstance = new EnchantedMazeFactory();
        }
        return enchantedMazeFactoryInstance;
    }

    public static MazeFactory getNormalMazeFactoryInstance() {
        if (normalMazeFactoryInstance == null) {
            normalMazeFactoryInstance = new NormalMazeFactory();
        }
        return normalMazeFactoryInstance;
    }

    public static MazeFactory getBombedMazeFactoryInstance() {
        if (bombedMazeFactoryInstance == null) {
            bombedMazeFactoryInstance = new BombedMazeFactory();
        }
        return bombedMazeFactoryInstance;
    }


    public abstract Door createDoor(Room room1, Room room2);


    public abstract Wall createWall();


    public abstract Room createRoom(int number, int x, int y);

}
