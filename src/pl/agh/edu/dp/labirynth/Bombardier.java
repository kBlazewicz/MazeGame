package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.mazeParts.Direction;
import pl.agh.edu.dp.labirynth.mazeParts.MapSite;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

import static java.lang.System.exit;

public class Bombardier {
    private int toBeBombarded = 0;

    public void checkForBombarding(Room roomA, Room roomB){
        if (this.toBeBombarded > 0) {
            if (roomB.equals(roomA)) {
                toBeBombarded += 1;
            }
            if (toBeBombarded >= 3) {
                System.out.println("You were bombarded!");
                exit(0);
            }
        }

        if (roomB.isBeingBombarded()){
            if(this.toBeBombarded == 0){
                this.toBeBombarded = 1;
            }
            System.out.println("You have 2 attempts to leave the room or you are going to die");
        } else {
            this.toBeBombarded = 0;
        }
    }
}
