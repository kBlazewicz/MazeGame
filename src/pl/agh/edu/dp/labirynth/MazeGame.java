package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builder.FactoryMazeBuilder;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

public class MazeGame {
    public Maze createMaze(MazeBuilder mazeBuilder) {
        Room room1 = mazeBuilder.buildRoom(0, 0);
        Room room2 = mazeBuilder.buildRoom(0, 0);

        mazeBuilder.buildWalls(room1);
        mazeBuilder.buildWalls(room2);

        mazeBuilder.buildDoor(room1, room2);

        return mazeBuilder.getMaze();
    }

    public Maze createMaze(MazeFactory mazeFactory, String filepath) {
        FactoryMazeBuilder builder = new FactoryMazeBuilder(mazeFactory);
        return builder.generateMaze(filepath);
    }

    public Maze addToMaze(MazeFactory mazeFactory, String filepath, Maze maze) {
        FactoryMazeBuilder builder = new FactoryMazeBuilder(mazeFactory, maze);
        return builder.generateMaze(filepath);
    }
}
