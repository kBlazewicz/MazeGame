package pl.agh.edu.dp.labirynth.mazeParts.normal;

import pl.agh.edu.dp.labirynth.mazeParts.MapSite;

public class Wall extends MapSite {
    public Wall() {

    }

    @Override
    public Room Enter(Room currentRoom) {
        System.out.println("You walked into a Wall");
        return currentRoom;
    }
}
