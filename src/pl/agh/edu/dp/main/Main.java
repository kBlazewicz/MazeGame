package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();

        // BUILDER
//        StandardBuilderMaze builder = new StandardBuilderMaze();

        // FACTORY
        MazeFactory factory = MazeFactory.getNormalMazeFactoryInstance();
        Maze maze = mazeGame.createMaze(factory,
                "src/pl/agh/edu/dp/maps/map1.txt");

        mazeGame.addToMaze(MazeFactory.getBombedMazeFactoryInstance(),
                "src/pl/agh/edu/dp/maps/map2.txt",
                maze);

        System.out.println(maze.getRoomNumbers());
        Player player = new Player(maze.getStartingRoom(), maze.getFinalRoom());


        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        while (true) {
            System.out.print("Enter move: ");
            String input = sc.nextLine();
            player.goDirection(input);
        }


//
//
//        MazeFactory enchantedMazeFactory = MazeFactory.getEnchantedMazeFactoryInstance();
//        Maze enchantedMaze = mazeGame.createMaze(enchantedMazeFactory);
//        System.out.println(enchantedMaze.getRoomNumbers());
//
//
//        MazeFactory bombedMazeFactory = MazeFactory.getBombedMazeFactoryInstance();
//        Maze bombedMaze = mazeGame.createMaze(bombedMazeFactory);
//        System.out.println(bombedMaze.getRoomNumbers());
//
//        MazeFactory bombedMazeFactory2 = MazeFactory.getBombedMazeFactoryInstance();
//        System.out.println(bombedMazeFactory2+"\n"+bombedMazeFactory);
    }
}



