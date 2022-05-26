import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.main.OutputManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeGUI {
    private JPanel mainPanel ;
    private JPanel topDoor;
    private JPanel rightDoor;
    private JPanel leftDoor;
    private JPanel downDoor;
    private JLabel TopDoorLabel;
    private JButton goLeftButton;
    private JButton goRightButton;
    private JButton goUpButton;
    private JButton goDownButton;
    private JTextField messageTextField;
    private JTextField oldMessageField;

    private final MazeGame mazeGame;
    private final Maze maze;
    private final Player player;
    public MazeGUI() {

        this.mazeGame = new MazeGame();
        MazeFactory factory = MazeFactory.getNormalMazeFactoryInstance();
        this.maze = mazeGame.createMaze(factory,
                "src/pl/agh/edu/dp/maps/map1.txt");

        mazeGame.addToMaze(MazeFactory.getBombedMazeFactoryInstance(),
                "src/pl/agh/edu/dp/maps/map2.txt",
                maze);

        this.player = new Player(maze.getStartingRoom(), maze.getFinalRoom());


        goUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.goDirection("up");
                messageTextField.setText(OutputManager.getConsoleMessage1());
                oldMessageField.setText(OutputManager.getConsoleMessage2());            }
        });

        goDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.goDirection("down");
                messageTextField.setText(OutputManager.getConsoleMessage1());
                oldMessageField.setText(OutputManager.getConsoleMessage2());            }
        });

        goLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.goDirection("left");
                messageTextField.setText(OutputManager.getConsoleMessage1());
                oldMessageField.setText(OutputManager.getConsoleMessage2());
            }
        });
        goRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.goDirection("right");
                messageTextField.setText(OutputManager.getConsoleMessage1());
                oldMessageField.setText(OutputManager.getConsoleMessage2());            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MazeGUI");
        frame.setContentPane(new MazeGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
