package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.mazeParts.Direction;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class FactoryMazeBuilder implements MazeBuilder {
    private final static List<Room> rooms = new ArrayList<>();
    private final MazeFactory mazeFactory;
    protected Maze currentMaze;

    public FactoryMazeBuilder(MazeFactory mazeFactory) {
        this.mazeFactory = mazeFactory;
        this.currentMaze = new Maze();
    }

    public FactoryMazeBuilder(MazeFactory mazeFactory, Maze currentMaze) {
        this.mazeFactory = mazeFactory;
        this.currentMaze = currentMaze;
    }


    public Maze generateMaze(String filePath) {
        File file = new File(filePath);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            exit(1);
        }

        String line;
        while (in.hasNextLine()) {
            // process the line
            line = in.nextLine();
            if (Objects.equals(line, "Doors")) {
                break;
            }
            String[] xy = line.split(" ");
            Room room = buildRoom(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
            rooms.add(room);
            buildWalls(room);
        }

        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] xy = line.split(" ");
            buildDoor(rooms.get(Integer.parseInt(xy[0])),
                    rooms.get(Integer.parseInt(xy[1])));
        }

        System.out.println("Latest edition of created rooms: " + rooms);
        return currentMaze;
    }

    @Override
    public Room buildRoom(int x, int y) {
        Room room = mazeFactory.createRoom(currentMaze.getRoomNumbers(), x, y);
        currentMaze.addRoom(room);
        return room;
    }

    @Override
    public void buildWalls(Room room) {
        room.setSide(Direction.North, mazeFactory.createWall());
        room.setSide(Direction.East, mazeFactory.createWall());
        room.setSide(Direction.West, mazeFactory.createWall());
        room.setSide(Direction.South, mazeFactory.createWall());
    }

    @Override
    public void buildDoor(Room room1, Room room2) {
        Direction common = commonWall(room1, room2);
        if (common == null) {
            return;
        }
        Door door = mazeFactory.createDoor(room1, room2);
        room1.setSide(common, door);
        room2.setSide(commonWall(room2, room1), door);
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
