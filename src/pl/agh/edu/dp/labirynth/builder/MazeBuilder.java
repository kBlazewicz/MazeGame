package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

public interface MazeBuilder {
    Room buildRoom(int x, int y);

    void buildWalls(Room room);

    void buildDoor(Room room1, Room room2);

    Maze getMaze();
}
