package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

import java.util.List;

public class CountingMazeBuilder implements MazeBuilder {
    private int roomCount = 0;
    private int wallCount = 0;
    private int doorCount = 0;

    public List<Integer> getCounts() {
        return List.of(roomCount, wallCount, doorCount);
    }

    @Override
    public Room buildRoom(int x, int y) {
        roomCount += 1;
        return null;
    }

    @Override
    public void buildWalls(Room room) {
        wallCount += 1;
    }

    @Override
    public void buildDoor(Room room1, Room room2) {
        doorCount += 1;
    }

    @Override
    public Maze getMaze() {
        return null;
    }
}
