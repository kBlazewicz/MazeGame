package pl.agh.edu.dp.labirynth.mazeParts.normal;

import pl.agh.edu.dp.labirynth.mazeParts.MapSite;
import pl.agh.edu.dp.main.OutputManager;

public class Wall extends MapSite {
    public Wall() {

    }

    @Override
    public Room Enter(Room currentRoom) {
        OutputManager.setConsoleMessage("You walked into a Wall");
        return currentRoom;
    }
}
