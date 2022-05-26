package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }

    public Room getStartingRoom() {
        return rooms.get(0);
    }

    public Room getFinalRoom() {
        return rooms.get(rooms.size() - 1);
    }
}
