package pl.agh.edu.dp.labirynth.mazeParts.normal;

import pl.agh.edu.dp.labirynth.mazeParts.MapSite;
import pl.agh.edu.dp.main.OutputManager;

public class Door extends MapSite {
    private Room room1;
    private Room room2;

    public Door(Room r1, Room r2) {
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public Room Enter(Room currentRoom) {
        Room room;
        if (currentRoom.equals(room1)) {
            room = room2;
        } else {
            room = room1;
        }
        OutputManager.setConsoleMessage("You entered the room: " + room.getRoomNumber() +
                " from " + currentRoom.getRoomNumber());
        return room;
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    @Override
    public String toString() {
        return "Normal Door";
    }
}
