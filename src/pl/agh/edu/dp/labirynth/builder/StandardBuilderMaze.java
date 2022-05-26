package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.mazeParts.Direction;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Wall;

public class StandardBuilderMaze implements MazeBuilder {
    Maze currentMaze;

    public StandardBuilderMaze() {
        currentMaze = new Maze();
    }


    @Override
    public Room buildRoom(int x, int y) {
        Room room = new Room(currentMaze.getRoomNumbers(), x, y);
        currentMaze.addRoom(room);
        return room;
    }

    @Override
    public void buildWalls(Room room) {
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.West, new Wall());
        room.setSide(Direction.South, new Wall());
    }

    @Override
    public void buildDoor(Room room1, Room room2) {
        Direction common = commonWall(room1, room2);
        if (common == null) {
            return;
        }
        Door door = new Door(room1, room2);
        room1.setSide(common, door);
        room1.setSide(commonWall(room2, room1), door);
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }


    //return the direction of room1's wall that is connected with room2
    private Direction commonWall(Room room1, Room room2) {
        if (room1.getX() == room2.getX()) {
            if (room1.getY() > room2.getY()) {
                return Direction.South;
            }
            return Direction.North;
        } else if (room1.getY() == room2.getY()) {
            if (room1.getX() > room2.getX()) {
                return Direction.West;
            }
            return Direction.East;
        } else {
            return null;
        }
    }

}
