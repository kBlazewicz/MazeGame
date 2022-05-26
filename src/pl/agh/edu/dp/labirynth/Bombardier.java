package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;
import pl.agh.edu.dp.main.OutputManager;

public class Bombardier {
    private int toBeBombarded = 0;
    private final Player player;

    public Bombardier(Player player) {
        this.player = player;
    }

    public void checkForBombarding(Room roomA, Room roomB) {
        if (this.toBeBombarded > 0) {
            if (roomB.equals(roomA)) {
                toBeBombarded += 1;
            }
            if (toBeBombarded >= 3) {
                OutputManager.setConsoleMessage("Player deactivated");
                OutputManager.setConsoleMessage("You were BOMBARDED!");
                this.player.deactivate();
            }
        }

        if (roomB.isBeingBombarded()) {
            if (this.toBeBombarded == 0) {
                this.toBeBombarded = 1;
                OutputManager.setConsoleMessage("BOMB! 2 attempts to leave!");
            }
        } else {
            this.toBeBombarded = 0;
        }
    }
}
